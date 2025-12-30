use std::io::{self, BufRead};

fn plus_minus(arr: &[i32]) {
    let n = arr.len() as f64;
    let mut positive = 0.0;
    let mut negative = 0.0;
    let mut zero = 0.0;

    for &value in arr {
        if value > 0 {
            positive += 1.0;
        } else if value < 0 {
            negative += 1.0;
        } else {
            zero += 1.0;
        }
    }
    println!("{:.6}", positive/n);
    println!("{:.6}", negative/n);
    println!("{:.6}", zero/n);

}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();

    stdin_iterator.next().unwrap().unwrap().trim().parse::<i32>().unwrap();

    let arr: Vec<i32> = stdin_iterator.next().unwrap().unwrap()
        .trim_end()
        .split(' ')
        .map(|s| s.to_string().parse::<i32>().unwrap())
        .collect();

    plus_minus(&arr);
}
