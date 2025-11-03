fn display_message(message: &String) {
    println!("{}", message);
}

fn display_message2(message: &str) {
    println!("{}", message);
}

fn main() {
    let text = String::from("Rust data");
    display_message(&text);
    println!("{}", text.clone());

    let text2: &str = "Most used";
    display_message2(text2);
}
