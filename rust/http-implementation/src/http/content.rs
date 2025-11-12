use std::{fs, io, path::Path};

use mime::Mime;

#[cfg(test)]
mod tests;

pub type Message = Vec<u8>;

pub fn load_content_from_uri(uri: &str) -> Result<Message, io::Error> {
    // make this get directly from env path
    let path = Path::new(uri);
    fs::read(path)
}

pub fn find_mimetype(filename: &str) -> Mime {
    let parts: Vec<&str> = filename.split(".").collect();
    let result = match parts.last() {
        Some(v) => match *v {
            "html" => mime::TEXT_HTML,
            "png" => mime::IMAGE_PNG,
            "jpg" => mime::IMAGE_JPEG,
            "json" => mime::APPLICATION_JSON,
            &_ => mime::TEXT_PLAIN,
        },
        None => mime::TEXT_PLAIN,
    };
    result
}

pub fn build_content_type(mime: &Mime) -> String {
    format!("Content-Type: {}/{}\r\n", mime.type_(), mime.subtype())
}
