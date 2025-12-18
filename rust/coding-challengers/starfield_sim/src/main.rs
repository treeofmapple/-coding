use macroquad::prelude::*;

const STAR_COUNT: usize = 800;

pub struct Star {
    x: f32,
    y: f32,
    z: f32,
    pz: f32,
}

impl Star {
    fn new () -> Self {
        let half_w = screen_width() / 2.0;
        let half_h = screen_height() / 2.0;
        let z = rand::gen_range(0.0, half_w);

        Self {
            x: rand::gen_range(-half_w, half_w),
            y: rand::gen_range(-half_h, half_h),
            z,
            pz: z,
        }
    }

    #[inline(always)]
    fn update_and_draw(&mut self, speed: f32, hw: f32, hh: f32) {
        self.z -= speed;
        if self.z < 1.0 {
            let half_w = screen_width() / 2.0;
            let half_h = screen_height() / 2.0;

            self.z = half_w;
            self.x = rand::gen_range(-half_w, half_w);
            self.y = rand::gen_range(-half_h, half_h);
            self.pz = self.z;
        }

        let inv_z = 1.0 / self.z;
        let inv_pz = 1.0 / self.pz;

        let sx = self.x * inv_z * hw + hw;
        let sy = self.y * inv_z * hh + hh;

        let px = self.x * inv_pz * hw + hw;
        let py = self.y * inv_pz * hh + hh;

        let r = (1.0 - self.z / hw) * 16.0;

        draw_circle(sx, sy, r.max(0.5), WHITE);
        draw_line(px, py, sx, sy, 1.0, WHITE);

        self.pz = self.z;
    }

    #[allow(dead_code)]
    fn update(&mut self, speed: f32) {
        self.z -= speed;

        if self.z < 1.0 {
            let half_w = screen_width() / 2.0;
            let half_h = screen_height() / 2.0;

            self.z = half_w;
            self.x = rand::gen_range(-half_w, half_w);
            self.y = rand::gen_range(-half_h, half_h);
            self.pz = self.z;
        }
    }

    #[allow(dead_code)]
    fn show(&mut self) {
        let half_w = screen_width() / 2.0;
        let half_h = screen_height() / 2.0;

        let inv_z = 1.0 / self.z;
        let sx = self.x * inv_z * half_w;
        let sy = self.y * inv_z * half_h;

        let r = (1.0 - self.z / half_w) * 16.0;

        draw_circle(
            sx+half_w,
            sy+half_h,
            r,
            WHITE,
        );
        let px = map(self.x / self.pz, 0.0, 1.0, 0.0, half_w);
        let py = map(self.y / self.pz, 0.0, 1.0, 0.0, half_h);

        draw_line(
            px + half_w,
            py + half_h,
            sx + half_w,
            sy + half_h,
            1.0,
            WHITE,
        );

        self.pz = self.z;
    }

}

fn lerp(a: f32, b: f32, t: f32) -> f32 {
    a + (b - a) * t
}

fn smooth_step(x: f32) -> f32 {
    x * x * (3.0 - 2.0 * x)
}

#[warn(dead_code)]
fn map(value: f32, in_min: f32, in_max: f32, out_min: f32, out_max: f32) -> f32 {
    (value - in_min) * (out_max - out_min) / (in_max - in_min) + out_min
}

#[macroquad::main("Starfield")]
async fn main() {
    let mut stars: Vec<Star> = (0..STAR_COUNT).map(|_| Star::new()).collect();
    let mut current_speed = 0.0;
    let max_speed = 5.0;

    loop {
        clear_background(BLACK);

        let x = (mouse_position().0 / screen_width()).clamp(0.0, 1.0);

        let dist = (x - 0.5).abs() * 2.0;

        let center_weigth = smooth_step(1.0 - dist);

        let target_speed = center_weigth * max_speed;

        current_speed = lerp(current_speed, target_speed, 0.05);

        let half_w = screen_width() * 0.5;
        let half_h = screen_height() * 0.5;

        for star in stars.iter_mut() {
            star.update_and_draw(current_speed, half_w, half_h);
        }

        next_frame().await;
    }
}
