package BinaryTree;

public class BinaryBalancedTree {

	private AvlNode root;

	class AvlNode {

		private Comparable element;
		private AvlNode left, right;
		private int height;

		public AvlNode(Comparable e, AvlNode l, AvlNode r) {
			element = e;
			left = l;
			right = r;
			height = 0;
		}

		private int height(AvlNode t) {
			return t == null ? -1 : t.height;
		}
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public Comparable find(Comparable x) {
		return find(x, root);
	}

	private Comparable find(Comparable x, AvlNode t) {
		if (t == null) {
			return null;
		}

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0) {
			return find(x, t.left);
		} else if (compareResult > 0) {
			return find(x, t.right);
		} else {
			return t.element; 
		}
	}

	public Comparable findMin() {
		if (isEmpty()) {
			return null;
		}

		return findMin(root).element;
	}

	private AvlNode findMin(AvlNode t) {
		if (t == null) {
			return null;
		} else if (t.left == null) {
			return t;
		}

		return findMin(t.left);
	}

	public Comparable findMax() {
		if (isEmpty()) {
			return null;
		}

		return findMax(root).element;
	}

	private AvlNode findMax(AvlNode t) {
		if (t == null) {
			return null;
		} else if (t.right == null) {
			return t;
		}

		return findMax(t.right);
	}

	public void insert(Comparable x) {
		root = insert(x, root);
	}

	private AvlNode insert(Comparable x, AvlNode t) {
		if (t == null) {
			return new AvlNode(x, null, null);
		}

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0) {
			t.left = insert(x, t.left);
		} else if (compareResult > 0) {
			t.right = insert(x, t.right);
		} else {
			// Duplicate; do nothing
		}

		return balance(t);
	}

	public void remove(Comparable x) {
		root = remove(x, root);
	}

	private AvlNode remove(Comparable x, AvlNode t) {
		if (t == null) {
			return t; 
		}

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0) {
			t.left = remove(x, t.left);
		} else if (compareResult > 0) {
			t.right = remove(x, t.right);
		} else if (t.left != null && t.right != null) {
			t.element = findMin(t.right).element;
			t.right = remove((Comparable) t.element, t.right);
		} else {
			t = (t.left != null) ? t.left : t.right;
		}

		return balance(t);
	}

	private static final int ALLOWED_IMBALANCE = 1;

	private AvlNode balance(AvlNode t) {
		if (t == null) {
			return t;
		}

		if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
			if (height(t.left.left) >= height(t.left.right)) {
				t = rotateWithLeftChild(t);
			} else {
				t = doubleWithLeftChild(t);
			}
		} else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
			if (height(t.right.right) >= height(t.right.left)) {
				t = rotateWithRightChild(t);
			} else {
				t = doubleWithRightChild(t);
			}
		}

		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	private static int height(AvlNode t) {
		return t == null ? -1 : t.height;
	}

	private static int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	private static AvlNode rotateWithLeftChild(AvlNode k2) {
		AvlNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;

		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;

		return k1;
	}

	private static AvlNode rotateWithRightChild(AvlNode k1) {
		AvlNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;

		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.right), k1.height) + 1;

		return k2;
	}

	private static AvlNode doubleWithLeftChild(AvlNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private static AvlNode doubleWithRightChild(AvlNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	public void printTree() {
		if (isEmpty()) {
			System.out.println("Empty tree");
		} else {
			printTree(root);
		}
	}

	private void printTree(AvlNode t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}

}