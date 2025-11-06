use crate::http::content::{find_mimetype, load_content_from_uri};

#[test]
fn test_load_existing_file() {
    let uri = "example/hello.html";

    let result = load_content_from_uri(&uri);

    assert!(result.is_ok());
}

#[test]
fn test_load_non_existing_png_file() {
    let uri = "non_existing.png";

    let result = load_content_from_uri(&uri);

    assert!(result.is_err());
}

#[test]
fn test_find_html_mime_type() {
    let filepath = "example/content.html";

    let result = find_mimetype(filepath);

    assert_eq!(result, mime::TEXT_HTML);
}

#[test]
fn test_find_png_mime_type() {
    let filepath = "example/content.png";

    let result = find_mimetype(filepath);

    assert_eq!(result, mime::IMAGE_PNG);
}

#[test]
fn test_find_non_existing_type() {
    let filepath = "example/content.pn";

    let result = find_mimetype(filepath);

    assert_eq!(result, mime::TEXT_PLAIN);
}
