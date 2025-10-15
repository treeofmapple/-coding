use testing_30::*;

pub fn eat_at_restaurant() {
    crate::front_of_house::hosting::add_to_waitlist();

    front_of_house::hosting::add_to_waitlist();

    back_of_house::serving::serve_order();
}


fn main() {
    eat_at_restaurant();

}
