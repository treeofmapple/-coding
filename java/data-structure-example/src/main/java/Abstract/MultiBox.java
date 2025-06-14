package Abstract;

import java.util.Random;

public class MultiBox {

	private int[] elements; // The elements like { 1,2,3,4,5 }
	private int size;       
	/* The Size of an array, like the 
	 * quantity of elements on an array
	*/
	private int capacity;   // The capacity of the array

	public MultiBox() {
		size = 0;
		elements = new int[capacity = 5];
	}

	public MultiBox(int capacity) {
		size = 0;
		this.capacity = capacity;
		elements = new int[capacity];
	}

	public boolean isEmpty() { // Not used more often used on other cases
		return (size == 0);
	}
	
	public void storeNumber(int element) {
		resizeCapacity();
		elements[size] = element;
		size++;
	}

	public int giveNumber() {
		Random gen = new Random();
		return elements[gen.nextInt(size)];
	}
	
	public int[] fullList() {
		return elements;
	}

	private void resizeCapacity() {
		if (size == capacity) {
			int[] newElement = new int[capacity *= 2];
			for (int i = 0; i < size; i++)
				newElement[i] = elements[i];
			elements = newElement;
		}
	}
}
