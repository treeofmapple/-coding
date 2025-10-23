use rand::Rng;
use std::cmp::Ordering;
use std::io as codar;
use std::net::IpAddr;

fn main() {
    let home: IpAddr = "127.0.0.1"
        .parse::<IpAddr>()
        .inspect(|ip| println!("Parsed IP: {}", ip))
        .expect("Hardcoded IP address should be valid");

    let secret_number = rand::thread_rng().gen_range(1..=100);

    loop {
        println!("Please input your guess {}", secret_number);

        let mut guess = String::new();

        codar::stdin()
            .read_line(&mut guess)
            .expect("Failed to read the line");

        let guess = guess.trim();

        if guess.eq_ignore_ascii_case("exit") {
            println!("Goodbye!");
            break;
        }

        let guess: i32 = match guess.parse() {
            Ok(num) => num,
            Err(_) => {
                println!("Please enter a valid number");
                continue;
            }
        };

        if guess < 1 || guess > 100 {
            println!("The secret number will be between 1 and 100");
            continue;
        }

        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too Small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win {}", secret_number);
                break;
            }
        }
    }
}
