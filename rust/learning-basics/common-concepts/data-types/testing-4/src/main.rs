fn main() {
    let spaces = "";
    let spaces = spaces.len();

    let mut spaces2 = "  ";
    spaces2 = spaces2.len();
    // expected `&str`, found `usize`

    println!("{spaces}");
    println!("{spaces2}");
}
