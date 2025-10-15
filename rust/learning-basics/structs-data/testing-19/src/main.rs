#[derive(Debug)]
struct Rectangle {
    width: u32,
    height: u32,
}

impl Rectangle {
    fn area(&self) -> u32 {
        self.width * self.height
    }

    fn width(&self) -> bool {
        self.width > 0
    }

    fn square(size: u32) -> Self {
        Self {
            width: size,
            height: size,
        }
    }

    fn retangle(size: u32, height: u32) -> Self {
        Self {
            width: size,
            height: height,
        }
    }

    fn set_width(&mut self, width: u32) {
        self.width = width;
    }

    fn set_height(&mut self, height: u32) {
        self.height = height;
    }

    fn max(self, other: Rectangle) -> Rectangle {
        Rectangle {
            width: self.width.max(other.width),
            height: self.height.max(other.height),
        }
    }
}

impl Rectangle {
    fn can_hold(&self, other: &Rectangle) -> bool {
        self.width > other.width && self.height > other.height
    }

    fn get_height(&self) -> u32 {
        self.height
    }

    fn get_width(&self) -> u32 {
        self.width
    }
}

fn first_part() {
    let rect1 = Rectangle {
        width: 30,
        height: 50,
    };

    println!(
        "The area of the rectangle is {} square pixels.",
        rect1.area()
    );
}

fn second_part() {
    let rect1 = Rectangle {
        width: 30,
        height: 50,
    };

    if rect1.width() {
        println!("The rectangle has a nonzero width; it is {}", rect1.width);
    }
}

fn three_part() {
    let rect1 = Rectangle {
        width: 30,
        height: 50,
    };
    let rect2 = Rectangle {
        width: 10,
        height: 40,
    };
    let rect3 = Rectangle {
        width: 60,
        height: 45,
    };

    println!("Can rect1 hold rect2? {}", rect1.can_hold(&rect2));
    println!("Can rect1 hold rect3? {}", rect1.can_hold(&rect3));
}

fn four_part() {
    let mut r = Rectangle {
        width: 1,
        height: 2,
    };

    let area1 = r.area();
    let area2 = Rectangle::area(&r);
    assert_eq!(area1, area2);

    r.set_width(4);
    Rectangle::set_width(&mut r, 8);
    println!("{}", r.get_height());
    println!("{}", r.get_width());

    let r = &mut Box::new(Rectangle {
        width: 1,
        height: 2,
    });

    let area1 = r.area();
    let area2 = Rectangle::area(&**r);
    assert_eq!(area1, area2);
}

fn five_part_pointer() {
    let r = &mut Box::new(Rectangle {
        width: 1,
        height: 2,
    });
    let area1 = r.area();
    let area2 = Rectangle::area(&**r);
    assert_eq!(area1, area2);
}

fn main() {
    first_part();
    second_part();
    three_part();
    four_part();
    five_part_pointer();
}
