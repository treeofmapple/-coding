fn main() {
    println!("Hello, World!");

    another_function();

    calculation(32);

    print_measured(21, 'q');
}

fn another_function() {
    println!("Another function");
}

fn calculation(x: i32) {
    println!("The value of the x is: {x}");
}

fn print_measured(value: i32, unit_label: char) {
    println!("The measurement is: {value}{unit_label}");
}
