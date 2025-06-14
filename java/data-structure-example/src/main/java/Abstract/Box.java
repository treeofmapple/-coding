package Abstract;

import java.util.Random;

public class Box {

	private Object[] elements;
	private int capacity;
	private int size;

	public Box() {
		size = 0;
		capacity = 5;
		elements = new Object[capacity];
	}

	public Box(int capacity) {
		size = 0;
		this.capacity = capacity;
		elements = new Object[capacity];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void storeElement(Object element) {
		resizeIfNeeded();
		elements[size] = element;
		size++;
	}
	
	public Object[] fullList() {
		return elements;
	}

	public Object getElement() {
		if (isEmpty())
			return null;

		Random generator = new Random();
		return elements[generator.nextInt(size)];
	}

	private void resizeIfNeeded() {
		if (size == capacity) {
			capacity *= 2;
			Object[] newElements = new Object[capacity];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
		}
	}
}
