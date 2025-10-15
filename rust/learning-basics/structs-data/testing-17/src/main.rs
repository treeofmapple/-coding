#[derive(Debug)]
struct Rectangle {
    width: u32,
    height: u32,
}

fn main() {

    let rect1 = Rectangle {
        width: 30,
        height: 50,
    };

    let width1 = 30;
    let height1 = 50;
    let tuple = (30, 50);

    println!(
        "The area of the rectangle is {} square pixels.",
        area1(width1, height1)
    );

    println!(
        "The area of the rectangle is {} square pixels.",
        area2(tuple)
    );

    println!(
        "The area of the rectangle is {} square pixels.",
        area3(&rect1)
    );

    println!("rect1 is {:?}", rect1);

    dbg!(&rect1);

    let scale = 2;
    let datasd = Rectangle {
        width: dbg!(30 * scale),
        height: 50,
    };
    dbg!(&datasd);
}

fn area1(width: u32, height: u32) -> u32 {
    width * height
}

fn area2(dimensions: (u32, u32)) -> u32 {
    dimensions.0 * dimensions.1
}

fn area3(rectangle: &Rectangle) -> u32 {
    rectangle.width * rectangle.height
}