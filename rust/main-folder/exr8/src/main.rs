enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
}

fn take_direction(select: Direction) -> String {
    match select {
        Direction::UP => String::from("UP"),
        Direction::DOWN => String::from("DOWN"),
        Direction::LEFT => String::from("LEFT"),
        Direction::RIGHT => String::from("RIGHT"),
    }
}

fn main() {
    println!("{}", take_direction(Direction::UP));
    println!("{}", take_direction(Direction::DOWN));
    println!("{}", take_direction(Direction::LEFT));
    println!("{}", take_direction(Direction::RIGHT));
}
