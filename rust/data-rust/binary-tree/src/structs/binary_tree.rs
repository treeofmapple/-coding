use crate::{errors::errors::EmptyTreeError, structs::binary_node::BinaryNode};

pub struct BinaryTree {
    pub root: Option<Box<BinaryNode>>,
}

impl BinaryTree {
    pub fn new() -> Self {
        BinaryTree { root: None }
    }

    pub fn is_empty(&self) -> bool {
        self.root.is_none()
    }

    pub fn clean(&mut self) {
        self.root = None;
    }

    pub fn insert(&mut self, value: i32) {
        if let Some(ref mut root) = self.root {
            root.insert(value);
        } else {
            self.root = Some(Box::new(BinaryNode::new(value)));
        }
    }

    pub fn remove(&mut self, value: i32) {
        if let Some(root) = self.root.take() {
            self.root = root.remove(value);
        }
    }

    pub fn print(&self) {
        if let Some(ref root) = self.root {
            root.print_preorder();
        } else {
            println!("Tree is empty");
        }
    }

    pub fn check_empty(&self) -> Result<(), EmptyTreeError> {
        if self.is_empty() {
            Err(EmptyTreeError)
        } else {
            Ok(())
        }
    }

    pub fn find_min(&self) -> Option<i32> {
        self.root.as_ref().map(|node| node.find_min())
    }

    pub fn find_max(&self) -> Option<i32> {
        self.root.as_ref().map(|node| node.find_max())
    }
}
