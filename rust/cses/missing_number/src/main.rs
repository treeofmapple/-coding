use std::io::{self, BufRead, Write};

fn missing_number(len: i32, array: &[i32]) -> i32 {
    let n = len as i64;
    let expected_sum = n * (n + 1) / 2;
    let actual_sum: i64 = array.iter().map(|&x| x as i64).sum();
    (expected_sum - actual_sum) as i32
}

fn main() {
    let mut input = io::stdin().lock().lines();

    let n = input
        .next()
        .unwrap()
        .unwrap()
        .trim()
        .parse::<i32>()
        .unwrap();

    let arr: Vec<i32> = input
        .next()
        .unwrap()
        .unwrap()
        .trim_end()
        .split(' ')
        .map(|s| s.to_string().parse::<i32>().unwrap())
        .collect();

    let result = missing_number(n, &arr);
    writeln!(io::stdout().lock(), "{}", result).ok();
}
