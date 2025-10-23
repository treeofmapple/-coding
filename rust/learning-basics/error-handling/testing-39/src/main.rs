use std::{fs::File, io::ErrorKind};
use testing_39::{errors::Result, operations::read_username_from_file};

fn main() {
    let res: Result<i32, &'static str> = Result::Ok(42);

    match res {
        Result::Ok(v) => println!("Success: {}", v),
        Result::Err(e) => println!("Failed: {}", e),
    }

    let greeting_file_result = File::open("hello.txt");

    match greeting_file_result {
        Ok(_) => println!("Successfully opened the file hello.txt"),
        Err(error) => panic!("Problem opening the file: {:?}", error),
    };

    println!("Print result {}", greeting_file_result.is_ok());

    let greeting_file_result2 = File::open("hello.txt");

    let _greeting_file2 = match greeting_file_result2 {
        Ok(file) => file,
        Err(error) => match error.kind() {
            ErrorKind::NotFound => match File::create("hello.txt") {
                Ok(fc) => fc,
                Err(e) => panic!("Problem creating the file: {e:?}"),
            },
            _ => {
                panic!("Problem opening the file: {error:?}");
            }
        },
    };

    let _greeting_file3 = File::open("hello.txt").unwrap_or_else(|error| {
        if error.kind() == ErrorKind::NotFound {
            File::create("hello.txt").unwrap_or_else(|error| {
                panic!("Problem creating the file: {error:?}");
            })
        } else {
            panic!("Problem opening the file: {error:?}");
        }
    });

    let _greeting_file4 = File::open("hello.txt").unwrap();

    let _greeting_file5 =
        File::open("hello.txt").expect("hello.txt should be included in this project");

    let _ = read_username_from_file();
}
