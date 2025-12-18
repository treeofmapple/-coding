use macroquad::prelude::*;

const MAX_DEPTH: usize = 4;
const MAX_CUBES: usize = 200_000;

#[derive(Clone)]
pub struct Box3D {
    pos: Vec3,
    r: f32,
}

impl Box3D {
    fn new(x: f32, y: f32, z: f32, r: f32) -> Self {
        Self {
            pos: vec3(x,y,z),
            r,
        }
    }

    fn generate(&self) -> Vec<Box3D> {
        let mut boxes = Vec::new();
        let new_r = self.r / 3.0;

        for x in -1..=1i32 {
            for y in -1..=1i32 {
                for z in -1..=1i32 {
                    let sum = x.abs() + y.abs() + z.abs();
                    if sum > 1 {
                        boxes.push(Box3D::new(
                            self.pos.x + x as f32 * new_r,
                            self.pos.y + y as f32 * new_r,
                            self.pos.z + z as f32 * new_r,
                            new_r,
                        ));
                    }
                }
            }
        }
        boxes
    }

    fn draw(&self) {
        draw_cube(
            self.pos,
            vec3(self.r, self.r, self.r),
            None,
            WHITE,
        );
    }

    fn draw_hud(cubes: usize, depth: usize) {
        let fps = get_fps();

        draw_text(&format!("FPS: {}", fps), 20.0, 30.0, 24.0, WHITE);
        draw_text(&format!("CUBES: {}", cubes), 20.0, 60.0, 24.0, WHITE);
        draw_text(&format!("Depth: {} / {}", depth, MAX_DEPTH), 20.0, 90.0, 24.0, WHITE);
    }
}

#[macroquad::main("Menger Sponge")]
async fn main() {
    let mut sponge: Vec<Box3D> = vec![Box3D::new(0.0, 0.0, 0.0, 2.0)];
    let mut depth: usize = 0;

    loop {
        clear_background(Color::from_rgba(51, 51, 51, 255));

        set_camera(&Camera3D {
            position: vec3(6.0, 6.0, 6.0),
            up: vec3(0.0, 1.0, 0.0),
            target: vec3(0.0, 0.0, 0.0),
            ..Default::default()
        });

        if is_mouse_button_pressed(MouseButton::Left) && depth < MAX_DEPTH {
            let estimated = sponge.len() * 20;
            if estimated > MAX_CUBES {
                panic!("Too many cubes — aborting to protect system");
            }

            let mut next = Vec::with_capacity(estimated);
            for b in &sponge {
                next.extend(b.generate());
            }
            sponge = next;
            depth += 1;
        }

        for b in &sponge {
            b.draw();
        }

        set_default_camera();
        Box3D::draw_hud(sponge.len(), depth);
        next_frame().await;

    }

}
