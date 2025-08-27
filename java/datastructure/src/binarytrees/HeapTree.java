package binarytrees;

@SuppressWarnings("unchecked")
public class HeapTree<T extends Comparable<? super T>> {

	private T[] array;
	private int size;
	private int capacity = 100;

	public HeapTree() {
		array = (T[]) new Comparable[capacity + 1];
		size = 0;
	}

	public void makeEmpty() {
		size = 0;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void insert(T x) {
		int hole = ++size;
		reziseIfNeeds();
		// Percolação ascendente
		for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
			array[hole] = array[hole / 2];
		array[hole] = x;
	}

	private void reziseIfNeeds() {
		if (size == capacity) {
			capacity *= 2;
			T[] newArray = (T[]) new Comparable[capacity + 1];
			for (int i = 1; i <= size; i++)
				newArray[i] = array[i];
			array = newArray;
		}
	}

	public T deleteMin() {
		if (isEmpty())
			return null;
		T minItem = array[1];
		array[1] = array[size--];
		percolateDown(1);
		return minItem;
	}

	private void percolateDown(int hole) {
		int child;
		T tmp = array[hole];
		for (; hole * 2 <= size; hole = child) {
			child = hole * 2;
			if (child != size && array[child + 1].compareTo(array[child]) < 0)
				child++;
			if (array[child].compareTo(tmp) < 0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = tmp;
	}
}
