use std::io::{self, BufRead, Write};

fn compare_triplets(a: &[i32], b: &[i32]) -> Vec<i32> {
    let mut alice = 0;
    let mut bob = 0;

    for i in 0..a.len() {
        if a[i] > b[i] {
            alice += 1;
        } else if a[i] < b[i] {
            bob += 1;
        }
    }
    vec![alice, bob]
}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();

    let stdout = io::stdout();
    let mut fptr = stdout.lock();

    let a: Vec<i32> = stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim_end()
        .split(' ')
        .map(|s| s.to_string().parse::<i32>().unwrap())
        .collect();

    let b: Vec<i32> = stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim_end()
        .split(' ')
        .map(|s| s.to_string().parse::<i32>().unwrap())
        .collect();

    let result = compare_triplets(&a, &b);

    for i in 0..result.len() {
        write!(&mut fptr, "{}", result[i]).ok();
        if i != result.len() - 1 {
            write!(&mut fptr, " ").ok();
        }
    }

    writeln!(&mut fptr).ok();
}
