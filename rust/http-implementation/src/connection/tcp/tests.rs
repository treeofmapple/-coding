use std::io::{self, Read, Write};

use crate::{connection::tcp::TcpServerConnection, http::server::ServerError};

struct TestStream {
    input_data: Vec<u8>,
    output_data: Vec<u8>,
    was_flushed: bool,
}

impl Write for TestStream {
    fn write(&mut self, buf: &[u8]) -> io::Result<usize> {
        self.output_data = Vec::from(buf);
        Ok(0)
    }
    fn flush(&mut self) -> io::Result<()> {
        self.was_flushed = true;
        Ok(())
    }
}

impl Read for TestStream {
    fn read(&mut self, buf: &mut [u8]) -> io::Result<usize> {
        for (buf_byte, data) in buf.iter_mut().zip(self.input_data.iter()) {
            *buf_byte = *data
        }
        Ok(0)
    }
}

#[test]
fn success_request_handling() {
    let mut stream = TestStream {
        input_data: String::from("input").as_bytes().to_vec(),
        output_data: vec![],
        was_flushed: false,
    };

    TcpServerConnection::handle_incoming_connection(
        |_| Ok(String::from("output").as_bytes().to_vec()),
        &mut stream,
    );

    assert_eq!(
        stream.output_data,
        String::from("output").as_bytes().to_vec()
    );
    assert!(stream.was_flushed,);
}

#[test]
fn failure_request_handling() {
    let mut stream = TestStream {
        input_data: String::from("input").as_bytes().to_vec(),
        output_data: vec![],
        was_flushed: false,
    };

    TcpServerConnection::handle_incoming_connection(
        |_| Err(ServerError::new("Test error")),
        &mut stream,
    );

    assert_eq!(stream.output_data, String::from("").as_bytes().to_vec());
    assert!(!stream.was_flushed,);
}
