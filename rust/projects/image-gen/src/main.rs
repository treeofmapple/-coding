use std::error::Error;

use image::{Rgb, RgbImage};
use noise::{NoiseFn, Perlin, Worley};
use rand::Rng;
use raqote::{DrawOptions, DrawTarget, PathBuilder, SolidSource, Source, StrokeStyle};
use svg::Document;
use svg::node::element::{Circle, Rectangle};

fn main() -> Result<(), Box<dyn Error>> {
    let width = 512;
    let height = 512;

    for i in 0..5 {
        let generated = generate_random_gradient(width, height)?;
        let filename = format!("gradient_{i}.png");
        generated.save(&filename).unwrap();
        println!("Saved {filename}");
    }

    let mut dt = DrawTarget::new(256, 256);
    dt.clear(SolidSource::from_unpremultiplied_argb(255, 240, 240, 240));

    let mut pb = PathBuilder::new();
    pb.arc(128.0, 128.0, 80.0, 0.0, std::f32::consts::PI * 2.0);
    let circle = pb.finish();

    dt.fill(
        &circle,
        &Source::Solid(SolidSource::from_unpremultiplied_argb(255, 100, 180, 255)),
        &DrawOptions::new(),
    );
    dt.stroke(
        &circle,
        &Source::Solid(SolidSource::from_unpremultiplied_argb(255, 20, 80, 160)),
        &StrokeStyle {
            width: 5.0,
            ..Default::default()
        },
        &DrawOptions::new(),
    );

    dt.write_png("icon.png").unwrap();

    let mut rng = rand::rng();
    let color = format!(
        "rgb({},{},{})",
        rng.random_range(0..255),
        rng.random_range(0..255),
        rng.random_range(0..255)
    );

    let icon = Document::new()
        .set("viewBox", (0, 0, 256, 256))
        .add(
            Rectangle::new()
                .set("width", 256)
                .set("height", 256)
                .set("fill", "#eee"),
        )
        .add(
            Circle::new()
                .set("cx", 128)
                .set("cy", 128)
                .set("r", 80)
                .set("fill", color),
        );

    svg::save("icon.svg", &icon).unwrap();

    let seed = rng.random_range(0..10000);
    let noise_type = rng.random_range(0..2);

    println!(
        " Generating texture with seed {seed}, type: {}",
        if noise_type == 0 { "Perlin" } else { "Worley" }
    );

    let img = match noise_type {
        0 => generate_perlin_texture(width, height, seed),
        _ => generate_worley_texture(width, height, seed),
    };

    img.save("procedural_texture.png")?;

    Ok(())
}

pub fn generate_random_gradient(width: u32, height: u32) -> Result<RgbImage, Box<dyn Error>> {
    let mut rng = rand::rng();
    let mut img = RgbImage::new(width, height);

    let top_left = [rng.random::<u8>(), rng.random::<u8>(), rng.random::<u8>()];
    let top_right = [rng.random::<u8>(), rng.random::<u8>(), rng.random::<u8>()];
    let bottom_left = [rng.random::<u8>(), rng.random::<u8>(), rng.random::<u8>()];
    let bottom_right = [rng.random::<u8>(), rng.random::<u8>(), rng.random::<u8>()];

    for y in 0..height {
        for x in 0..width {
            let xf = x as f32 / (width - 1) as f32;
            let yf = y as f32 / (height - 1) as f32;

            let mut color = [0u8; 3];
            for i in 0..3 {
                let top = top_left[i] as f32 * (1.0 - xf) + top_right[i] as f32 * xf;
                let bottom = bottom_left[i] as f32 * (1.0 - xf) + bottom_right[i] as f32 * xf;
                color[i] = (top * (1.0 - yf) + bottom * yf) as u8;
            }

            img.put_pixel(x, y, Rgb(color));
        }
    }

    Ok(img)
}

fn generate_perlin_texture(width: u32, height: u32, seed: u32) -> RgbImage {
    let perlin = Perlin::new(seed);
    let mut img = RgbImage::new(width, height);

    for y in 0..height {
        for x in 0..width {
            let nx = x as f64 / width as f64;
            let ny = y as f64 / height as f64;

            let value = perlin.get([nx * 6.0, ny * 6.0]);
            let v = ((value + 1.0) * 127.5) as u8;

            img.put_pixel(x, y, Rgb([v, v, (v as f32 * 0.8) as u8]));
        }
    }

    img
}

fn generate_worley_texture(width: u32, height: u32, seed: u32) -> RgbImage {
    let worley = Worley::new(seed);
    let mut img = RgbImage::new(width, height);

    for y in 0..height {
        for x in 0..width {
            let nx = x as f64 / width as f64;
            let ny = y as f64 / height as f64;

            let value = worley.get([nx * 8.0, ny * 8.0]);
            let v = ((value + 1.0) * 127.5) as u8;

            img.put_pixel(x, y, Rgb([(v as f32 * 1.2) as u8, v, (255 - v)]));
        }
    }

    img
}
