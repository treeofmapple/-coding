use std::cell::RefCell;

use crate::http::{
    content::{Message, load_content_from_uri},
    server::{Connection, ServerError},
};

struct TestConnection {
    pull_message: Vec<Vec<u8>>,
    push_message: RefCell<Vec<Vec<u8>>>,
}

impl TestConnection {
    fn new() -> TestConnection {
        TestConnection {
            pull_message: vec![
                String::from("1").as_bytes().to_vec(),
                String::from("2").as_bytes().to_vec(),
                String::from("3").as_bytes().to_vec(),
            ],
            push_message: RefCell::new(vec![]),
        }
    }
}

impl Connection for TestConnection {
    fn listen<T: 'static + Copy + Fn(&[u8]) -> Result<Message, ServerError> + Send + Sync>(
        &self,
        callback: T,
    ) {
        let response = (callback)(&self.pull_message[0]).unwrap();
        self.push_message.borrow_mut().push(response)
    }
}

#[test]
fn pull_message() {
    let test_connection = TestConnection::new();
    test_connection.listen(|_| Ok(String::from("Test").as_bytes().to_vec()));
    assert_eq!(
        String::from("Test").as_bytes().to_vec(),
        test_connection.push_message.borrow()[0]
    );
}

#[test]
fn test_load_non_existing_png_file() {
    let uri = "non_existing.png";

    let result = load_content_from_uri(&uri);

    assert!(result.is_err());
}
