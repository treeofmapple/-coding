use std::fmt::*;

#[derive(Debug)]
pub struct BinaryNode {
    pub element: i32,
    pub left: Option<Box<BinaryNode>>,
    pub right: Option<Box<BinaryNode>>,
}

impl BinaryNode {
    pub fn new(element: i32) -> Self {
        BinaryNode {
            element,
            left: None,
            right: None,
        }
    }

    pub fn insert(&mut self, value: i32) {
        if value < self.element {
            if let Some(ref mut left) = self.left {
                left.insert(value);
            } else {
                self.left = Some(Box::new(BinaryNode::new(value)));
            }
        } else if value > self.element {
            if let Some(ref mut right) = self.right {
                right.insert(value);
            } else {
                self.right = Some(Box::new(BinaryNode::new(value)));
            }
        }
    }

    pub fn print_preorder(&self) {
        println!("{}", self.element);
        if let Some(ref left) = self.left {
            left.print_preorder();
        }
        if let Some(ref right) = self.right {
            right.print_preorder();
        }
    }

    pub fn remove(self: Box<Self>, value: i32) -> Option<Box<BinaryNode>> {
        if value < self.element {
            let mut node = *self;
            node.left = match node.left.take() {
                Some(left) => left.remove(value),
                None => None,
            };
            Some(Box::new(node))
        } else if value > self.element {
            let mut node = *self;
            node.right = match node.right.take() {
                Some(right) => right.remove(value),
                None => None,
            };
            Some(Box::new(node))
        } else {
            match (self.left, self.right) {
                (None, None) => None,
                (Some(left), None) => Some(left),
                (None, Some(right)) => Some(right),
                (Some(left), Some(right)) => {
                    let min_val = right.find_min();
                    let mut new_right = right.remove(min_val);
                    let mut new_node = BinaryNode::new(min_val);
                    new_node.left = Some(left);
                    new_node.right = new_right.take();
                    Some(Box::new(new_node))
                }
            }
        }
    }

    pub fn find_min(&self) -> i32 {
        match &self.left {
            Some(left) => left.find_min(),
            None => self.element,
        }
    }

    pub fn find_max(&self) -> i32 {
        let mut current = self;
        while let Some(ref right) = current.right {
            current = right;
        }
        current.element
    }
}
