fn main() {
    let x = five();
    println!("The value is: {x}");
    let y = plus_one(12);
    println!("The value is: {y}");
    
    println!("{}", f({let y = 1; y + 1}));
}

fn five() -> i32 {
    5
}

fn plus_one(x: i32) -> i32 {
    x + 1
}

fn f(x: i32) -> i32 {
    x + 1
}
