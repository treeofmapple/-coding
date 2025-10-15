struct Point(i32, i32);

fn main() {
    let p = Point(1, 2);
    impl p {
        fn x(&self) -> i32 {
            self.0
        }
    }

    println!("{}", p.x());
}
