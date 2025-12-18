use std::{i32, io::{self, BufRead}};

fn mini_max_sum(arr: &[i64]) {
    let mut sum: i64 = 0;
    let mut min = i64::MAX;
    let mut max = i64::MIN;

    for &value in arr {
        sum += value;
        if value < min {
            min = value;
        }
        if value > max {
            max = value;
        }
    }
    println!("{} {}", sum - max, sum - min);
}

/*
fn mini_max_sum(arr: &[i64]) {
    let sum: i64 = arr.iter().sum();
    let min = arr.iter().min().unwrap();
    let max = arr.iter().max().unwrap();
    let min_sum = sum - max;
    let max_sum = sum - min;
    println!("{} {}", min_sum, max_sum);
}
*/

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();

    let arr: Vec<i64> = stdin_iterator.next().unwrap().unwrap()
        .trim_end()
        .split(' ')
        .map(|s| s.to_string().parse::<i64>().unwrap())
        .collect();

    mini_max_sum(&arr);
}
