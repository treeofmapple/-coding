use std::{fmt, str::FromStr};

use http::StatusCode;

use crate::http::{
    content::{Message, build_content_type, find_mimetype, load_content_from_uri},
    request::{HttpMethod, HttpRequest},
};

#[cfg(test)]
mod tests;

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

impl fmt::Display for ServerError {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "{}", self.msg)
    }
}

pub trait Connection {
    fn listen<T: 'static + Copy + Fn(&[u8]) -> Result<Vec<u8>, ServerError> + Send + Sync>(
        &self,
        callback: T,
    );
}

pub struct Server<T>
where
    T: Connection,
{
    connection: T,
}

impl<T: Connection> Server<T> {
    pub fn new(connection: T) -> Server<T> {
        Server { connection }
    }

    pub fn run(&self) {
        self.connection
            .listen(|request| Self::request_handler(request));
    }

    fn request_handler(request: &[u8]) -> Result<Message, ServerError> {
        std::str::from_utf8(request)
            .map_or_else(
                |_| {
                    Err(ServerError::new(
                        "Unable to convert request to utf8 format. Request rejected",
                    ))
                },
                |request| Ok(HttpRequest::from_str(request)),
            )?
            .map_or_else(
                |_| Ok(Self::build_not_implemented_response()),
                |http_request| match http_request.line.method {
                    HttpMethod::Get => Self::handle_get_request(&http_request),
                    HttpMethod::Post => Self::handle_post_request(&http_request),
                    HttpMethod::Put => Self::handle_put_request(&http_request),
                    HttpMethod::Delete => Self::handle_delete_request(&http_request),
                },
            )
    }

    fn handle_get_request(request: &HttpRequest) -> Result<Message, ServerError> {
        let mime = find_mimetype(&request.line.uri[1..]);

        load_content_from_uri(&request.line.uri[1..]).map_or_else(
            |_| Ok(Self::build_not_found_response()),
            |content| {
                let response = Self::build_http_response(200).unwrap();
                let content_type = build_content_type(&mime);
                let blank_line = "\r\n";
                let mut message = Vec::new();
                message.extend_from_slice(response.as_bytes());
                message.extend_from_slice(content_type.as_bytes());
                message.extend_from_slice(blank_line.as_bytes());
                message.extend_from_slice(&content);
                Ok(message)
            },
        )
    }

    fn handle_post_request(request: &HttpRequest) -> Result<Message, ServerError> {
        let mime = find_mimetype(&request.line.uri[1..]);
        load_content_from_uri(&request.line.uri[1..]).map_or_else(
            |_| Ok(Self::build_not_found_response()),
            |content| {
                Ok(content)
            },
        )
    }

    fn handle_put_request(request: &HttpRequest) -> Result<Message, ServerError> {
        let mime = find_mimetype(&request.line.uri[1..]);
        load_content_from_uri(&request.line.uri[1..]).map_or_else(
            |_| Ok(Self::build_not_found_response()),
            |content| {
                Ok(content)
            },
        )
    }

    fn handle_delete_request(request: &HttpRequest) -> Result<Message, ServerError> {
        let mime = find_mimetype(&request.line.uri[1..]);
        load_content_from_uri(&request.line.uri[1..]).map_or_else(
            |_| Ok(Self::build_not_found_response()),
            |content| {
                Ok(content)
            },
        )
    }

    fn build_not_found_response() -> Message {
        load_content_from_uri("404.html").map_or_else(
            |_| {
                format!(
                    "{}\r\n404 - Page Not Found",
                    Self::build_http_response(404).unwrap()
                )
                .into_bytes()
            },
            |content| {
                let response = Self::build_http_response(404).unwrap();
                let blank_line = "\r\n";
                let mut message = Vec::new();
                message.extend_from_slice(response.as_bytes());
                message.extend_from_slice(blank_line.as_bytes());
                message.extend_from_slice(&content);
                message
            },
        )
    }

    fn build_not_implemented_response() -> Message {
        format!("{}\r\n", Self::build_http_response(501).unwrap()).into_bytes()
    }

    fn build_http_response(status_code: u16) -> Result<String, ServerError> {
        StatusCode::from_u16(status_code).map_or_else(
            |_| Err(ServerError::new("Unknown status code")),
            |code| Ok(format!("HTTP/1.1 {} {}\r\n", status_code, code.as_str())),
        )
    }
}
