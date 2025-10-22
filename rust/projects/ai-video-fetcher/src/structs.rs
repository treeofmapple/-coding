#[derive(Serialize)]
pub struct GenerateVideoRequest<'a> {
    pub prompt: &'a str,
    pub video_config: VideoConfig,
}

#[derive(Deserialize, Debug)]
pub struct Operation {
    pub name: String,
    pub done: bool,
    #[serde(skip_serializing_if = "Option::is_none")]
    pub response: Option<VideoResponse>,
    #[serde(skip_serializing_if = "Option::is_none")]
    pub error: Option<Status>,
}

#[derive(Deserialize, Debug)]
pub struct VideoResponse {
    #[serde(rename = "generatedFiles")]
    pub generated_files: Vec<GeneratedFile>,
}

#[derive(Deserialize, Debug)]
pub struct GeneratedFile {
    #[serde(rename = "uri")]
    pub uri: String,
    #[serde(rename = "mimeType")]
    pub mime_type: String,
}

#[derive(Deserialize, Debug)]
pub struct Status {
    pub code: i32,
    pub message: String,
}

#[derive(Serialize)]
pub struct VideoConfig {
    #[serde(rename = "durationSeconds")]
    pub duration_seconds: u32,
    pub quality: String, // "low" | "medium" | "high"
}
