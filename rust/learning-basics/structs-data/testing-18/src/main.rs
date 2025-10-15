#[derive(Debug)]
struct Point {
    x: i32,
    y: i32,
}

#[derive(Debug)]
struct Rectangle {
    width: u32,
    height: u32,
}

fn main() {
    // question_one(); run answer: 2
    // question_two(); run answer: 2 3 
    // question_three(); throw exception
}

fn question_one() {
    let mut a = Point { x: 1, y: 2 };
    a.x += 1;
    let b = Point { y: 1, ..a };
    a.x += 1;
    println!("{}", b.x);
}

fn question_two() {
    let mut p = Point { x: 1, y: 2 };
    let x = &mut p.x;
    let y = &mut p.y;
    *x += 1;
    *y += 1;
    println!("{} {}", p.x, p.y);
}

fn question_three() {
    let rect1 = Rectangle {
        width: 30,
        height: 50,
    };
    let a = area1(rect1);
    println!("{} * {} = {}", rect1.width, rect1.height, a);
}

fn area1(rectangle: Rectangle) -> u32 {
    rectangle.width * rectangle.height
}
