use std::fmt::{Display, Formatter};

#[derive(Debug)]
pub struct EmptyTreeError;

impl Display for EmptyTreeError {
    fn fmt(&self, f: &mut Formatter) -> std::fmt::Result {
        write!(f, "The tree is empty")
    }
}
