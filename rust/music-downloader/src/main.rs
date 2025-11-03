#[tokio::main]
async fn main() -> anyhow::Result<()> {
    let url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";

    let video: Video = VideoFetcher::from_url(url)?.fetch().await()?;

    let stream = video
        .streams()
        .iter()
        .filter(|s| s.includes_audio_track && !s.includes_video_track)
        .max_by_key(|s| s.bitrate)
        .expect("No audio-only stream found");

    println!("Downloading audio: {}", stream.quality_label);

    let path = Path::new("music.mp4");
    stream.download_to(path).await?;

    println!("Download complete: {:?}", path);

    convert_to_mp3("music.mp4","music.mp3");
    println!("Converting to MP3");
    Ok(())
}

fn convert_to_mp3(input: &str, output: &str) -> std::io::Result<()> {
    Command::new("ffmpeg")
        .args(&["-i", input, "-vn", "-ab", "192k", "-ar", "44100", "-y", output])
        .status()?;
    Ok(())
}
