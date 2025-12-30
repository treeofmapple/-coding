use std::io::{self, BufRead, Write};

fn weird_algo(ar: &i32) -> i32 {
    *ar
}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();

    let stdout = io::stdout();
    let mut fptr = stdout.lock();

    let num: i32 = stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim()
        .parse::<i32>()
        .unwrap();

    stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim()
        .parse::<i32>()
        .unwrap();

    // Array
    let array: Vec<i32> = stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim_end()
        .split(' ')
        .map(|s| s.to_string().parse::<i32>().unwrap())
        .collect();

    let result = weird_algo(&num);
    writeln!(&mut fptr, "{}", result).ok();
}
