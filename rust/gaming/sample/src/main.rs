use glam::{Mat4, Vec3};
use wgpu::util::DeviceExt;
use winit::{
    event::*,
    event_loop::EventLoop,
    window::WindowBuilder,
};

#[repr(C)]
#[derive(Copy, Clone, Debug, bytemuck::Pod, bytemuck::Zeroable)]
struct Vertex {
    position: [f32; 3],
    color: [f32; 3],
}

impl Vertex {
    fn layout<'a>() -> wgpu::VertexBufferLayout<'a> {
        use std::mem;
        wgpu::VertexBufferLayout {
            array_stride: mem::size_of::<Vertex>() as u64,
            step_mode: wgpu::VertexStepMode::Vertex,
            attributes: &[
                wgpu::VertexAttribute {
                    offset: 0,
                    format: wgpu::VertexFormat::Float32x3,
                    shader_location: 0,
                },
                wgpu::VertexAttribute {
                    offset: 12,
                    format: wgpu::VertexFormat::Float32x3,
                    shader_location: 1,
                },
            ],
        }
    }
}

const CUBE_VERTICES: &[Vertex] = &[
    Vertex { position: [-1.0, -1.0,  1.0], color: [1.0, 0.0, 0.0] },
    Vertex { position: [ 1.0, -1.0,  1.0], color: [0.0, 1.0, 0.0] },
    Vertex { position: [ 1.0,  1.0,  1.0], color: [0.0, 0.0, 1.0] },
    Vertex { position: [-1.0,  1.0,  1.0], color: [1.0, 1.0, 0.0] },

    Vertex { position: [-1.0, -1.0, -1.0], color: [1.0, 0.0, 1.0] },
    Vertex { position: [ 1.0, -1.0, -1.0], color: [0.0, 1.0, 1.0] },
    Vertex { position: [ 1.0,  1.0, -1.0], color: [1.0, 1.0, 1.0] },
    Vertex { position: [-1.0,  1.0, -1.0], color: [0.0, 0.0, 0.0] },
];

const CUBE_INDICES: &[u16] = &[
    0, 1, 2, 2, 3, 0, // front
    1, 5, 6, 6, 2, 1, // right
    5, 4, 7, 7, 6, 5, // back
    4, 0, 3, 3, 7, 4, // left
    3, 2, 6, 6, 7, 3, // top
    4, 5, 1, 1, 0, 4, // bottom
];

#[repr(C)]
#[derive(Clone, Copy, bytemuck::Pod, bytemuck::Zeroable)]
struct Uniforms {
    mvp: [[f32; 4]; 4],
}

impl Uniforms {
    fn new() -> Self {
        Self {
            mvp: Mat4::IDENTITY.to_cols_array_2d(),
        }
    }

    fn update(&mut self, model: Mat4, view: Mat4, proj: Mat4) {
        let mvp = proj * view * model;
        self.mvp = mvp.to_cols_array_2d();
    }
}

#[tokio::main]
async fn main() {
    let event_loop = EventLoop::new().unwrap();
    let window = WindowBuilder::new().with_title("wgpu cube 3D").build(&event_loop).unwrap();

    let size = window.inner_size();
    let instance = wgpu::Instance::default();

    let surface = unsafe { instance.create_surface(&window) }.unwrap();
    let adapter = instance.request_adapter(&Default::default()).await.unwrap();
    let (device, queue) =
        adapter.request_device(&Default::default(), None).await.unwrap();

    let surface_format = surface.get_capabilities(&adapter).formats[0];
    let mut config = wgpu::SurfaceConfiguration {
        usage: wgpu::TextureUsages::RENDER_ATTACHMENT,
        format: surface_format,
        width: size.width,
        height: size.height,
        present_mode: wgpu::PresentMode::Fifo,
        alpha_mode: wgpu::CompositeAlphaMode::Auto,
        view_formats: vec![],
        // FIX 1: New mandatory field in wgpu 0.20
        desired_maximum_frame_latency: 2,
    };
    surface.configure(&device, &config);

    // --- Buffers ---
    let vertex_buffer = device.create_buffer_init(&wgpu::util::BufferInitDescriptor {
        label: Some("Vertex Buffer"),
        contents: bytemuck::cast_slice(CUBE_VERTICES),
        usage: wgpu::BufferUsages::VERTEX,
    });

    let index_buffer = device.create_buffer_init(&wgpu::util::BufferInitDescriptor {
        label: Some("Index Buffer"),
        contents: bytemuck::cast_slice(CUBE_INDICES),
        usage: wgpu::BufferUsages::INDEX,
    });

    // --- Uniforms ---
    let mut uniforms = Uniforms::new();
    let uniform_buffer = device.create_buffer_init(&wgpu::util::BufferInitDescriptor {
        label: Some("Uniform Buffer"),
        contents: bytemuck::bytes_of(&uniforms),
        usage: wgpu::BufferUsages::UNIFORM | wgpu::BufferUsages::COPY_DST,
    });

    let uniform_bind_group_layout =
        device.create_bind_group_layout(&wgpu::BindGroupLayoutDescriptor {
            label: None,
            entries: &[wgpu::BindGroupLayoutEntry {
                binding: 0,
                visibility: wgpu::ShaderStages::VERTEX,
                ty: wgpu::BindingType::Buffer {
                    ty: wgpu::BufferBindingType::Uniform,
                    has_dynamic_offset: false,
                    min_binding_size: None,
                },
                count: None,
            }],
        });

    let uniform_bind_group = device.create_bind_group(&wgpu::BindGroupDescriptor {
        layout: &uniform_bind_group_layout,
        entries: &[wgpu::BindGroupEntry {
            binding: 0,
            resource: uniform_buffer.as_entire_binding(),
        }],
        label: None,
    });

    // --- Shaders (WGSL) ---
    // Ensure shader.wgsl is in the src/ directory
    let shader = device.create_shader_module(wgpu::include_wgsl!("../shader.wgsl"));

    // --- Pipeline ---
    let render_pipeline_layout =
        device.create_pipeline_layout(&wgpu::PipelineLayoutDescriptor {
            label: None,
            bind_group_layouts: &[&uniform_bind_group_layout],
            push_constant_ranges: &[],
        });

    let render_pipeline =
        device.create_render_pipeline(&wgpu::RenderPipelineDescriptor {
            label: None,
            layout: Some(&render_pipeline_layout),
            vertex: wgpu::VertexState {
                module: &shader,
                entry_point: "vs_main",
                buffers: &[Vertex::layout()],
                // FIX 2: New mandatory field in wgpu 0.20
                compilation_options: wgpu::PipelineCompilationOptions::default(),
            },
            fragment: Some(wgpu::FragmentState {
                module: &shader,
                entry_point: "fs_main",
                targets: &[Some(wgpu::ColorTargetState {
                    format: surface_format,
                    blend: Some(wgpu::BlendState::REPLACE),
                    write_mask: wgpu::ColorWrites::ALL,
                })],
                // FIX 3: New mandatory field in wgpu 0.20
                compilation_options: wgpu::PipelineCompilationOptions::default(),
            }),
            primitive: wgpu::PrimitiveState::default(),
            depth_stencil: None,
            multisample: wgpu::MultisampleState::default(),
            multiview: None,
        });

    // --- Camera ---
    let view = Mat4::look_at_rh(
        Vec3::new(3.0, 3.0, 5.0),
        Vec3::ZERO,
        Vec3::Y,
    );

    let proj = Mat4::perspective_rh(
        45f32.to_radians(),
        config.width as f32 / config.height as f32,
        0.1,
        100.0,
    );

    let mut angle = 0.0_f32;

    event_loop.run(move |event, elwt| {
        match event {
            Event::WindowEvent { event: WindowEvent::CloseRequested, .. } =>
                elwt.exit(),

            Event::WindowEvent { event: WindowEvent::Resized(new_size), .. } => {
                config.width = new_size.width;
                config.height = new_size.height;
                surface.configure(&device, &config);
            }

            Event::AboutToWait => {
                angle += 0.02;
                let model = Mat4::from_rotation_y(angle);

                uniforms.update(model, view, proj);
                queue.write_buffer(&uniform_buffer, 0, bytemuck::bytes_of(&uniforms));

                let frame = surface.get_current_texture().unwrap();
                let view = frame.texture.create_view(&Default::default());

                let mut encoder =
                    device.create_command_encoder(&wgpu::CommandEncoderDescriptor { label: None });

                {
                    let mut render_pass =
                        encoder.begin_render_pass(&wgpu::RenderPassDescriptor {
                            label: None,
                            color_attachments: &[Some(wgpu::RenderPassColorAttachment {
                                view: &view,
                                resolve_target: None,
                                ops: wgpu::Operations {
                                    load: wgpu::LoadOp::Clear(wgpu::Color::BLACK),
                                    // FIX 4: Changed from boolean true to StoreOp::Store
                                    store: wgpu::StoreOp::Store,
                                },
                            })],
                            depth_stencil_attachment: None,
                            // FIX 5: New mandatory fields in wgpu 0.20
                            occlusion_query_set: None,
                            timestamp_writes: None,
                        });

                    render_pass.set_pipeline(&render_pipeline);
                    render_pass.set_bind_group(0, &uniform_bind_group, &[]);
                    render_pass.set_vertex_buffer(0, vertex_buffer.slice(..));
                    render_pass.set_index_buffer(index_buffer.slice(..), wgpu::IndexFormat::Uint16);
                    render_pass.draw_indexed(0..CUBE_INDICES.len() as _, 0, 0..1);
                }

                queue.submit(Some(encoder.finish()));
                frame.present();
            }

            _ => {}
        }
    }).unwrap(); // Added unwrap for the Result returned by run
}
