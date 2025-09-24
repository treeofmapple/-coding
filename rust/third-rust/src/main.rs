use std::io;
use rand::Rng;

fn main() {
    println!("Hello, world!");
    
    let secret_number = rand::rng().random_range(1..=100);
    
    println!("The secret number is: {secret_number}");
    
    println!("Please input your guess.");
    
    let mut guess = String::new();
    
    io::stdin().read_line(&mut guess).expect("Failed to read line");
    
    print!("You guessed: {guess}");
    
}
