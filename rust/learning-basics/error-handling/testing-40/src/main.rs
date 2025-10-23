use std::{fs::File, io::Read};

fn read_username_from_file() -> Option<String> {
    let mut username_file = File::open("hello.txt").ok()?;
    let mut username = String::new();
    username_file.read_to_string(&mut username).ok()?;
    Some(username)
}

fn main() {
    println!("{}", read_username_from_file().unwrap());
}
