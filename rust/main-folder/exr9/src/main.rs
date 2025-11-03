fn main() {
    let mut numbers = Vec::new();

    numbers.push(10);
    numbers.push(20);
    numbers.push(30);

    for number in &numbers {
        println!("{}", number);
    }
}
