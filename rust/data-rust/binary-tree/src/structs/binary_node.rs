pub struct BinaryNode {
    pub element: Option<i32>,
    pub left: Option<Box<BinaryNode>>,
    pub right: Option<Box<BinaryNode>>,
}

impl BinaryNode {
    pub fn new() -> Self {
        BinaryNode {
            element: None,
            left: None,
            right: None,
        }
    }
}

impl Default for BinaryNode {
    fn default() -> Self {
        Self::new()
    }
}
