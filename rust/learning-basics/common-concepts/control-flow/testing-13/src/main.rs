fn main() {
    let number = 5;
    let number2 = 7;

    run_if_check(number);
    run_if_check(number2);

    run_not_check(number);
    run_not_check(number2);

    check_divisible(number);
    check_divisible(number2);

    let condition = true;
    let number = if condition { 5 } else { 6 };

    // let number = if condition { 5 } else { "six" }; // Can't be like this

    println!("{number}");

}

fn run_if_check(number: u32) {
    if number > 5 {
        println!("Condition was true");
    } else {
        println!("Condition was false");
    }
}

fn run_not_check(number: u32) {
    if number != 0 {
        println!("Number was: {number}");
    } else {
        println!("number was zero");
    }
}

fn check_divisible(number: u32) {
    if number % 4 == 0 {
        println!("number is divisible by 4");
    } else if number % 3 == 0 {
        println!("number is divisible by 3");
    } else if number % 2 == 0 {
        println!("number is divisible by 2");
    } else {
        println!("number is not divisible by 4, 3, or 2");
    }
}
