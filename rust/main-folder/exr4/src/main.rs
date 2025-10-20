fn if_negative(value: i64) {
    if (value >= 1) {
        println!("Positivo");
    } else if (value <= -1) {
        println!("Negativo");
    } else {
        println!("Zero");
    }
}

fn main() {
    let vass = 0;
    if_negative(vass);
}
