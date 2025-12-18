use std::io;

fn main() {

    let mut num_str_1 = String::new();
    io::stdin().read_line(&mut num_str_1).ok().expect("read error");
    let num_1: i32 = (&num_str_1).trim().parse().unwrap();

    let mut num_str_2 = String::new();
    io::stdin().read_line(&mut num_str_2).ok().expect("read error");
    let num_2: i32 = (&num_str_2).trim().parse().unwrap();

    println!("{}", num_1 + num_2);

}
