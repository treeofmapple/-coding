use anyhow::Result;
use image::GenericImageView;
use ndarray::Array4;
use std::fs::File;
use std::io::{BufRead, BufReader};
use std::path::PathBuf;
use std::time::Instant;
use tract_onnx::prelude::*;

fn main() -> Result<()> {
    // --- Paths ---
    let data_dir = PathBuf::from(env!("CARGO_MANIFEST_DIR")).join("data");
    let labels_path = data_dir.join("imagenet_classes.txt");
    let model_path = data_dir.join("resnet50-v2-7.onnx");
    let image_path = data_dir.join("cat.jpeg");

    let labels = BufReader::new(File::open(&labels_path)?)
        .lines()
        .map(|l| l.unwrap())
        .collect::<Vec<String>>();

    let model = tract_onnx::onnx()
        .model_for_path(&model_path)?
        .with_input_fact(0, f32::fact(&[1, 3, 224, 224]).into())?
        .into_optimized()?
        .into_runnable()?;

    let img = image::open(&image_path)?;
    let resized_img = img.resize_exact(224, 224, image::imageops::FilterType::Triangle);

    let mut array: Array4<f32> = Array4::zeros((1, 3, 224, 224));
    for (x, y, pixel) in resized_img.pixels() {
        let r = (pixel[0] as f32 / 127.5) - 1.0;
        let g = (pixel[1] as f32 / 127.5) - 1.0;
        let b = (pixel[2] as f32 / 127.5) - 1.0;

        array[[0, 0, y as usize, x as usize]] = r;
        array[[0, 1, y as usize, x as usize]] = g;
        array[[0, 2, y as usize, x as usize]] = b;
    }

    let shape = &[1, 3, 224, 224];
    let input_tensor = Tensor::from_shape(shape, array.as_slice().unwrap())?;

    let start = Instant::now();
    let result = model.run(tvec!(input_tensor.into()))?;
    let duration = start.elapsed();

    let output = result[0].to_array_view::<f32>()?.iter().cloned().collect::<Vec<f32>>();
    let probs = softmax(&output);
    let (best_idx, max_prob) = probs
        .iter()
        .enumerate()
        .fold((0, 0.0), |(idx_max, val_max), (idx, &val)| {
            if val > val_max {
                (idx, val)
            } else {
                (idx_max, val_max)
            }
        });

    println!("--- Prediction ---");
    println!("Class: {}", labels[best_idx]);
    println!("Probability: {:.2}%", max_prob);
    println!("Time taken: {:.2?}", duration);

    Ok(())
}

fn softmax(logits: &[f32]) -> Vec<f32> {
    let max = logits.iter().cloned().fold(f32::MIN, f32::max);
    let exp: Vec<f32> = logits.iter().map(|x| (x - max).exp()).collect();
    let sum: f32 = exp.iter().sum();
    exp.iter().map(|x| x / sum * 100.0).collect()
}
