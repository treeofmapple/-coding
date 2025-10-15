fn main() {

    let x = true;
    read(x);

    // heap transfer

    let a = Box::new([0u8; 1_000_000]);
    let b = a.clone();

    let abc = vec![0; 1_000_000];
    let edb = abc;

    println!("Length = {}", a.len());
    println!("First 10 elements = {:?}", &a[..10]);

    let adcd = vec![0u8; 1_000_000].into_boxed_slice();
    println!("Length = {}", a.len());

}

fn read(y: bool) {
    if y {
        println!("Y is true");
    }
}