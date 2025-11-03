struct Car {
    name: String,
    year: u32
}

fn main() {
    let new_car = Car {
        name: String::from("Toyota"),
        year: 2
    };

    println!("Car Name: {}", new_car.name);
    println!("Car Year: {}", new_car.year);

}
