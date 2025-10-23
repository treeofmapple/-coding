fn main() {
    run_and_test();
}

fn run_and_test() {
    let v = vec![1, 2, 3];
    let value = 99;
    // v[99]; crash
    match v.get(value) {
        Some(x) => println!("Value: {}", x),
        None => panic!("Wasn't possible to find: {}", value),
    }
}
