package BinaryTree;

import Others.EmptyTreeException;

@SuppressWarnings("unchecked")
public class BinarySearchTree {

	private BinaryNode root;

	class BinaryNode {
		private int element;
		private BinaryNode left;
		private BinaryNode right;

		BinaryNode(int e, BinaryNode l, BinaryNode r) {
			element = e;
			left = l;
			right = r;
		}
	}

	public BinarySearchTree() {
		root = null;
	}

	public void clear() {
		root = null;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public void insert(int x) {
		root = insert(x, root);
	}

	public void remove(int x) {
		root = remove(x, root);
	}

	public void print() {
		if (isEmpty())
			System.out.println("Arvore Vazia");
		else
			print(root);
	}

	public boolean find(int x) {
		return find(x, root) != null ? true : false;
	}

	public int findMin() throws EmptyTreeException {
		if (isEmpty())
			throw new EmptyTreeException();
		return findMin(root).element;
	}

	public int findMax() throws EmptyTreeException {
		if (isEmpty())
			throw new EmptyTreeException();
		return findMax(root).element;
	}

	public BinaryNode insert(int x, BinaryNode t) {
		if (t == null)
			t = new BinaryNode(x, null, null);
		else if (x < t.element)
			t.left = insert(x, t.left);
		else if (x > t.element)
			t.right = insert(x, t.right);
		return t;
	}

	public BinaryNode find(int x, BinaryNode t) {
		if (t == null)
			return null;
		if (x < t.element)
			return find(x, t.left);
		else if (x > t.element)
			return find(x, t.right);
		else
			return t;
	}

	public BinaryNode remove(int x, BinaryNode t) {
		if (t == null)
			return t;
		if (x < t.element)
			t.left = remove(x, t.left);
		else if (x > t.element)
			t.right = remove(x, t.right);
		else if (t.left != null && t.right != null) {
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		}
		else
			t = (t.left != null) ? t.left : t.right;
		return t;
	}

	public BinaryNode findMin(BinaryNode t) {
		if (t.left == null)
			return t;
		return findMin(t.left);
	}

	public BinaryNode findMax(BinaryNode t) {
		while (t.right != null)
			t = t.right;
		return t;
	}

	private void print(BinaryNode t) {
		if (t != null) {
			System.out.println(t.element);
			print(t.left);
			print(t.right);
		}
	}

}
