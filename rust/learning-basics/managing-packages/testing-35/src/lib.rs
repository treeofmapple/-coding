pub use crate::front_of_house::hosting::add_to_waitlist;
pub use rand::Rng;
pub use std::collections::HashMap;
pub use std::collections::*;
pub use std::fmt::{self, Result};
pub use std::io::{self, Write};
// use std::{cmp::Ordering, io, write};
pub use std::io::Result as IoResults;

pub use crate::front_of_house::hosting;

mod front_of_house {
    pub mod hosting {
        pub fn add_to_waitlist() {}
    }
}

mod customer {
    use crate::front_of_house::hosting;
    pub fn eat_at_restaurant() {
        hosting::add_to_waitlist();
    }
}

/*
pub fn eat_at_restaurant() {
    hosting::add_to_waitlist();
}
 */

pub fn generate_random() -> u32 {
    rand::thread_rng().gen_range(1..=100)
}
