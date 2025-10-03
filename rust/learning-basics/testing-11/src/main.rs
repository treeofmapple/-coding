fn main() {
    let p = 6;
    let x = (let y = 6); // Will throw an error
    println!("{p}");
    println!("{x}");
}
