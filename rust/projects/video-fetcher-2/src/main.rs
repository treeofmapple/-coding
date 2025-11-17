use base64::{Engine as _, engine::general_purpose};
use reqwest::blocking::Client;
use serde_json::json;
use std::fs;
use std::fs::File;
use std::io::Write;

fn extend_video(
    api_key: &str,
    input_path: &str,
    output_path: &str,
    prompt: &str,
) -> Result<(), Box<dyn std::error::Error>> {
    let client = Client::new();

    let video_bytes = fs::read(input_path)?;
    let b64_video = general_purpose::STANDARD.encode(video_bytes);

    let payload = json!({
        "contents": [{
            "role": "user",
            "parts": [
                { "text": prompt },
                {
                    "video": {
                        "mimeType": "video/mp4",
                        "data": b64_video
                    }
                }
            ]
        }],
        "videoConfig": {
            "durationSeconds": 8,
            "fps": 24
        }
    });

    let res = client
        .post(format!(
            "https://generativelanguage.googleapis.com/v1beta/models/veo-3.1:continueVideo?key={}",
            api_key
        ))
        .json(&payload)
        .send()?;

    let bytes = res.bytes()?;

    let mut file = File::create(output_path)?;
    file.write_all(&bytes)?;

    println!("Extended video saved to {}", output_path);

    Ok(())
}

fn main() -> Result<(), Box<dyn std::error::Error>> {
    let api_key = std::env::var("GEMINI_API_KEY")?; // GEMINI_API_KEY=YOUR_GOOGLE_VEO_API_TOKEN_HERE
    let current = "clip1.mp4".to_string();

    for i in 0..12 {
        let next = format!("clip_extended_{}.mp4", i);

        extend_video(
            &api_key,
            &current,
            &next,
            "Continue the scene with the drone moving forward in the forest.",
        )?;

        fs::rename(&next, &current)?;
        println!("Round {} complete", i + 1);
    }

    println!("FINAL VIDEO: {}", current);

    Ok(())
}
