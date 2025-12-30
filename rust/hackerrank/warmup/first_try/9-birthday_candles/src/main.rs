use std::io::{self, BufRead, Write};

fn candles(candles: &[i32]) -> i32 {
    let mut max = None;
    let mut count = 0;

    for &x in candles {
        match max {
            None => {
                max = Some(x);
                count = 1;
            }
            Some(m) if x > m => {
                max = Some(x);
                count = 1;
            }
            Some(m) if x == m => {
                count += 1;
            }
            _ => {}
        }
    }

    count
}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();

    let stdout = io::stdout();
    let mut fptr = stdout.lock();

    let _candles_count = stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim()
        .parse::<i32>()
        .unwrap();

    let num: Vec<i32> = stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim_end()
        .split(" ")
        .map(|s| s.to_string().parse::<i32>().unwrap())
        .collect();

    let result = candles(&num);
    writeln!(&mut fptr, "{}", result).ok();
}
