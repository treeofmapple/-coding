#[warn(unused_variables)]
#[allow(dead_code)]
#[derive(Debug)] 
struct Color(i32, i32, i32);

#[warn(unused_variables)]
#[allow(dead_code)]
#[derive(Debug)] 
struct Point(i32, i32, i32);

#[allow(dead_code)]
struct Content { 
    x: i32, 
    y: i32 
}

#[allow(dead_code)]
struct AlwaysEqual;

#[derive(Debug)]
#[allow(dead_code)]
struct User {
    active: bool,
    username: String,
    email: String,
    password: String,
    sign_in_count: u64,
}

#[allow(dead_code)]
struct UserContent<'a> {
    username: &'a str,
    email: &'a str,
    sign_quantity: i64,
}

#[allow(dead_code)]
fn build_user(email: String, username: String, password: String) -> User {
    User {
        active: true, 
        username, 
        email,
        password,
        sign_in_count: 1,
    }
}

#[allow(dead_code)]
fn snip_content() {
    let userab = User {
        active: true,
        username: String::from("dasfijdsf"),
        email: String::from("someon@os.com"),
        password: String::from("2783t4e78y2g"),
        sign_in_count: 1,
    };

    let _userbb = User {
        active: userab.active,
        username: userab.username.clone(),
        email: userab.email.clone(),
        password: String::from("asdhg123"),
        sign_in_count: userab.sign_in_count,
    };

    let user_base = User {
        active: true,
        username: String::from("base_user"),
        email: String::from("base@os.com"),
        password: String::from("base_pass"),
        sign_in_count: 1,
    };

    let _user_temp2 = User {
        password: String::from("new_password"),
        ..user_base
    };

}

#[allow(dead_code)]
fn carlinhos() {
    let mut p = Point(0,0,0);

    let x = &mut p.0;
    *x += 1;

    println!("{}, {}", p.0, p.1);
}

#[allow(dead_code)]
fn print_point(p: &Point) {
    println!("{}, {}", p.0, p.1);
}

fn main() {
    let mut user1 = User {
        email: String::from("someon@os.com"),
        username: String::from("dasfijdsf"),
        password: String::from("2783t4e78y2g"),
        active: true,
        sign_in_count: 1,
    };
    println!("{:?}", user1);

    user1.email = String::from("ahsdkasd@gasdfa.com");
    println!("{:?}", user1);

    let _black = Color(1, 2, 3);
    let _origin = Point(3, 4, 5);
    let _subject = AlwaysEqual;
    carlinhos();

    /*

    let x = &mut p.x;
    print_point(&p);
    *x += 1;

    */

}
