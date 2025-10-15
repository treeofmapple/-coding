use testing_31::*;

pub fn eat_at_restaurant() {
    let meal = back_of_house::Breakfast::summer("Rye");
    let var_name = meal.toast == String::from("Wheat");
    println!("I'd like {} toast please", meal.toast);
    println!("And the season fruit is? {}", meal.get_season_fruit());
    println!("wawa {}", var_name);

    // meal.seasonal_fruit = String::from("blueberries");
}

fn main() {
    eat_at_restaurant();
}
