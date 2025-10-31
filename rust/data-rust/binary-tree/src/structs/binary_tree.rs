use crate::{errors::errors::EmptyTreeError, structs::binary_node::BinaryNode};

pub struct BinaryTree {
    pub root: Option<Box<BinaryNode>>,
}

impl BinaryTree {
    pub fn new(root: Option<Box<BinaryNode>>) -> Self {
        BinaryTree { root }
    } // make it generate two nodes left and right

    pub fn is_empty(&self) -> bool {
        self.root.is_none()
    }


}

fn is_empty(tree: &BinaryTree) -> Result<(), EmptyTreeError> {
    if tree.is_empty() {
        Err(EmptyTreeError)
    } else {
        Ok(())
    }
}
