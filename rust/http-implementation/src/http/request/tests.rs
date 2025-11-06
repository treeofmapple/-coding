use crate::http::request::{HttpMethod, HttpRequestLine, HttpVersion};

#[test]
fn parse_get_method() {
    let method = "GET";

    let result = HttpMethod::from_str(method);

    assert!(matches!(result, Ok(HttpMethod::Get)));
}

#[test]
fn parse_unknown_method() {
    let method = "UNKNOWN";

    let result = HttpMethod::from_str(method);

    assert!(matches!(result, Err(_)));
}

#[test]
fn parse_11_version() {
    let version = "HTTP/1.1";

    let result = HttpVersion::from_str(version);

    assert!(matches!(result, Ok(HttpVersion::V11)));
}

#[test]
fn parse_unknown_version() {
    let version = "UNKNOWN";

    let result = HttpVersion::from_str(version);

    assert!(matches!(result, Err(_)));
}

#[test]
fn parse_request_line() {
    let request_line = "GET /index.html HTTP/1.1 \r\n";

    let result = HttpRequestLine::from_str(request_line).expect("");

    assert!(matches!(result.method, HttpMethod::Get));
    assert_eq!(result.uri, String::from("/index.html"));
    assert!(matches!(result.version, HttpVersion::V11));
}

#[test]
fn parse_wrong_request_line() {
    let request_line = "GET /index.html HTTP/.1 \r\n";
    assert!(matches!(HttpRequestLine::from_str(request_line), Err(_)));
}
