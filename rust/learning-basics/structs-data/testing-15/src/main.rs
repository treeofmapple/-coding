struct Color(i32, i32, i32);
struct Point(i32, i32, i32);

struct Content { x: i32, y: i32 };

struct AlwaysEqual;

struct User {
    active: bool,
    username: String,
    email: String,
    password: String,
    sign_in_count: u64,
}

struct UserContent {
    username: &str,
    email: &str,
    sign_quantity: i64,
}

fn build_user(email: String, username: String, password: String) -> User {
    User {
        active: true, 
        username, 
        email,
        password,
        sign_in_count: 1,
    }
}

fn snip_content() {
    let userab = User {
        active: true,
        username: String::from("dasfijdsf"),
        email: String::from("someon@os.com"),
        password: String::from("2783t4e78y2g"),
        sign_in_count: 1,
    };

    let userbb = User {
        active: userab.active,
        username: userab.username,
        email: userab.email,
        password: String::from("asdhg123"),
        sign_in_count: userab.sign_in_count,
    };

    let userbc = User {
        ..userab
    };

}

fn carlinhos() {
    let mut p = Point {
        x: 0, y: 0
    };

    let x = &mut p.x;
    *x += 1;

    println!("{}, {}", p.x, p.y);
}

fn print_point(p: &Point) {
    println!("{}, {}", p.x, p.y);
}

fn main() {
    let user1 = User {
        email: String::from("someon@os.com"),
        username: String::from("dasfijdsf"),
        password: String::from("2783t4e78y2g"),
        active: true,
        sign_in_count: 1,
    };
    println!("{user1}");

    user1.email = String::from("ahsdkasd@gasdfa.com");
    println!("{user1}");

    let black = Color(1, 2, 3);
    let origin = Point(3, 4, 5);
    let subject = AlwaysEqual;
    carlinhos();

    /*

    let x = &mut p.x;
    print_point(&p);
    *x += 1;

    */
}
