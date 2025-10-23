use testing_35::*;

fn main() {
    let mut map = HashMap::new();
    map.insert(1, 2);
    println!("{}", map.len());

    println!("{}", generate_random());
}

fn function1() -> fmt::Result {
    Ok(())
}

fn function2() -> IoResults<()> {
    Ok(())
}
