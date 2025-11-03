use std::fmt::{Display, Formatter, Result};

#[derive(Debug)]
pub struct EmptyTreeError;

impl Display for EmptyTreeError {
    fn fmt(&self, f: &mut Formatter<'_>) -> Result {
        write!(f, "The tree is empty")
    }
}
