#[derive(Debug, Clone)]
pub struct ServerError {
    msg: String,
}

impl ServerError {
    pub(crate) fn new(msg: &str) -> ServerError {
        ServerError {
            msg: String::from(msg),
        }
    }
}
