use std::io::{self, BufRead, Write};

fn simple_array_sum(arr: &[i32]) -> i32 {
    let mut values = 0;
    for &x in arr {
        values += x;
    }
    values
}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();

    let stdout = io::stdout();
    let mut fptr = stdout.lock();

    stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim()
        .parse::<i32>()
        .unwrap();

    let ar: Vec<i32> = stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim_end()
        .split(' ')
        .map(|s| s.to_string().parse::<i32>().unwrap())
        .collect();

    let result = simple_array_sum(&ar);
    writeln!(&mut fptr, "{}", result).ok();
}
