use binary_tree::structs::binary_tree::BinaryTree;

fn main() {
    let mut tree = BinaryTree::new();

    tree.insert(50);
    tree.insert(30);
    tree.insert(70);
    tree.insert(20);
    tree.insert(40);
    tree.insert(60);
    tree.insert(80);

    println!("Preorder print:");
    tree.print();

    println!("\nRemoving 30...");
    tree.remove(30);

    println!("After removal:");
    tree.print();

    println!("{}", tree.is_empty());

    println!("Min value: {:?}", tree.find_min());
    println!("Max value: {:?}", tree.find_max());
}
