use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();

    let mut n: u64 = input.trim().parse().unwrap();

    loop {
        print!("{} ", n);
        if n == 1 {
            break;
        }
        if n % 2 == 0 {
            n /= 2;
        } else {
            n = 3 * n + 1;
        }
    }
}
