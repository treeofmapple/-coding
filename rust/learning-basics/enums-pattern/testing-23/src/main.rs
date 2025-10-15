enum Coin {
    Penny,
    Nickel,
    Dime,
    Quarter,
}

fn value_in_cents(coin: &Coin) -> u8 {
    match coin {
        Coin::Penny => {
            println!("Lucky penny!");
            1
        }
        Coin::Nickel => 5,
        Coin::Dime => 10,
        Coin::Quarter => 25,
    }
}

fn total_value(coins: &[Coin]) -> u8 {
    coins.iter().map(value_in_cents).sum()
}

fn main() {
    let coins = vec![
        Coin::Penny,
        Coin::Nickel,
        Coin::Dime,
        Coin::Quarter,
        Coin::Quarter,
    ];

    let acoin = Coin::Penny;
    let recieved = value_in_cents(&acoin);
    let total = total_value(&coins);
    println!("{recieved}");
    println!("Total value: {} cents", total);
}
