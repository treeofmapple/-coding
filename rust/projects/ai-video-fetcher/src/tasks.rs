use reqwest::Client;
use serde::{Deserialize, Serialize};
use std::{error, time::Duration};
use tokio::time::sleep;

use crate::{consts::generate_url, structs::GenerateVideoRequest};

pub async fn fetch_video(request_body: GenerateVideoRequest<'_>) -> Result<Vec<String>, Box<dyn Error>> {
    let client = Client::new();

    let token = fetch_google_token().await?;

    println!("Starting video generation...");

    let mut operation: Operation = client
        .post(&generate_url())
        .bearer_auth(&token)
        .json(&request_body)
        .send()
        .await?
        .json()
        .await?;

    println!("Operation started: {}", operation.name);

    let operation_url = format!(
        "https://{}-aiplatform.googleapis.com/v1/{}",
        LOCATION, operation.name
    );

    while !operation.done {
        println!("Checking status... (not done yet)");
        sleep(Duration::from_secs(10)).await;

        let poll_token = auth.token().await?;
        operation = client
            .get(&operation_url)
            .bearer_auth(poll_token.as_str())
            .send()
            .await?
            .json()
            .await?;
    }

    if let Some(err) = operation.error {
        eprintln!("Error generating video: {} (Code: {})", err.message, err.code);
        return Err("Video generation failed".into());
    }

    if let Some(resp) = operation.response {
        println!("\n✅ Video generation complete!");

        let uris: Vec<String> = resp
            .generated_files
            .iter()
            .map(|file| {
                println!("  - Mime Type: {}", file.mime_type);
                println!("  - Video URL: {}", file.uri);
                file.uri.clone()
            })
            .collect();
        Ok(uris)
    } else {
        eprintln!("Operation finished but no response found.");
        Err("No video response received".into())
    }

}

pub async fn download_video_fetched(uris: Vec<String>) -> Result<(), Box<dyn Error>> {
    let client = Client::new();

    for uri in uris {
        println!("Downloading from {}", uri);

        let resp = client.get(&uri).send().await?;
        let bytes = resp.bytes().await?;

        let filename = uri
            .split('/')
            .last()
            .unwrap_or("video.mp4")
            .to_string();

        tokio::fs::write(&filename, &bytes).await?;
        println!("Saved: {}", filename);
    }

    Ok(())
}

pub async fn fetch_google_token() -> Result<String, Box<dyn error::Error>> {
    let creds = CredentialsFile::from_file("service-account.json").await?;
    let provider = DefaultTokenSourceProvider::new_with_credentials(&creds)?;
    let ts = provider.token_source(&SCOPES)?;
    let token = ts.token().await?;
    Ok(token.access_token)
}
