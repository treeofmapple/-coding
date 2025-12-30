use std::io::{self, BufRead, Write};

fn time_conversion(s: &str) -> String {
    let s = s.trim();
    let period = &s[s.len() - 2..];
    let time = &s[..s.len() - 2];

    let mut parts = time.split(":");
    let mut hour: i32 = parts.next().unwrap().parse().unwrap();
    let minute = parts.next().unwrap();
    let second = parts.next().unwrap();

    if period == "PM" && hour != 12 {
        hour += 12;
    }
    if period == "AM" && hour == 12 {
        hour = 0;
    }

    format!("{:02}:{}:{}", hour, minute, second)
}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();

    let stdout = io::stdout();
    let mut fptr = stdout.lock();

    let info = stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim()
        .parse::<String>()
        .unwrap();

    let result = time_conversion(&info);
    writeln!(&mut fptr, "{}", result).ok();
}
