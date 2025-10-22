pub mod structs;
pub mod consts;
pub mod tasks;

use reqwest::Client;
use serde::{Deserialize, Serialize};
use std::{error::Error, time::Duration};
use tokio::time::sleep;

use crate::consts::{GENERATE_URL, SCOPES};

#[tokio::main]
async fn main() -> Result<(), Box<dyn error::Error>> {
    println!("Prompt a ser inserido");
    let mut input_line = String::new();
    io::stdin()
        .read_line(&mut input_line)
        .expect("Failed to read text");

    println!("Tempo de duração em segundos máximo: 180 segundos");
    let mut duration_time = String::new();
    io::stdin()
        .read_line(&mut duration_time)
        .expect("Failed to read duration");

    let duration_seconds: u32 = match
        duration_input.trim().parse(){
            Ok(num) => num,
            Err(_) => {
                eprintln!("Precisa ser inserido um número, valido.");
                std::process::exit(1);
            }
        };

    let request_body = GenerateVideoRequest {
        input_line.trim(),
        video_config: VideoConfig {
            duration_seconds: duration_seconds,
            quality: "high".to_string(),
        },
    };

    let uris = fetch_video(request_body).await?;
    download_video_fetched(uris).await?;

    Ok(())
}
