package lists;

public class ArrayLists {

	private Object[] elements;
	private int size;
	private int capacity;

	public ArrayLists() {
		size = 0;
		capacity = 5;
		elements = new Object[capacity];
	}

	public ArrayLists(int capacity) {
		size = 0;
		this.capacity = capacity;
		elements = new Object[capacity];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void print() {
		if (size == 0)
			System.out.println("<----Lista Vazia---->");
		else {
			System.out.println("<----Início---->");
			for (int i = 0; i < size; i++)
				System.out.print(elements[i] + (i == size - 1 ? "" : ", "));
			System.out.println("\n<----Fim---->");
		}
	}

	public boolean add(Object elem) {
		reziseCapacity();
		elements[size] = elem;
		size++;
		return true;
	}

	public void add(int index, Object elem) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index=" + index + " e Size=" + size);
		}
		reziseCapacity();
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
			size++;
		}
		elements[size] = elem;
		size++;
	}

	private void reziseCapacity() {
		if (size == capacity) {
			Object[] newElements = new Object[capacity *= 2];
			for (int i = 0; i < size; i++)
				newElements[i] = elements[i];
			elements = newElements;
		}
	}

}
