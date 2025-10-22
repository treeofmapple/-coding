pub const PROJECT_ID: &str = "project-id";
pub const LOCATION: &str = "us-central1";
pub const MODEL_ID: &str = "veo-3.1-generate-preview";
pub const SCOPES: [&str; 1] = ["https://www.googleapis.com/auth/cloud-platform"];

pub fn generate_url() -> String {
    format!(
        "https://{}-aiplatform.googleapis.com/v1/projects/{}/locations/{}/publishers/google/models/{}:generateVideo",
        LOCATION, PROJECT_ID, LOCATION, MODEL_ID
    )
}
