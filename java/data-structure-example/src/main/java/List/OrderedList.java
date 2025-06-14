package List;

import java.util.Random;

public class OrderedList {

	private Comparable[] elements;
	private int size;
	private int capacity = 5;

	// Constructor to initialize the elements array and size
	public OrderedList() {
		size = 0;
		elements = new Comparable[capacity];
	}
	
	public OrderedList(int capacity) {
		size = 0;
		this.capacity = capacity;
		elements = new Comparable[capacity];
	}

	// Inner class representing a student (Aluno)
	class Aluno implements Comparable <Aluno> {
		private String nome;
		private String matricula;
		private String[] randomed = {"John","Marlon","Michael","Dovan","Eldri"};
		
		public Aluno() {
			Random random = new Random();
			String randomized = randomed[random.nextInt(randomed.length)];
			
			nome = randomized;
			matricula = "";
		}
		
		public Aluno(String n) {
			nome = n;
			matricula = "000000";
		}
		
		public Aluno(String n, String m) {
			nome = n;
			matricula = m;
		}

		@Override
		public String toString() {
			return nome + (matricula.isEmpty() ? "" : "-" + matricula) ;
		}

		@Override
		public int compareTo(Aluno a) {
			return this.nome.compareTo(a.nome);
		}
	}

	// Method to get the size of the list
	public int size() {
		return size;
	}

	// Method to check if the list is empty
	public boolean isEmpty() {
		return size == 0;
	}

	// Method to add an element to the list
	public boolean add(Comparable elem) {
		if (size == capacity) {
			expandCapacity();
		}
		elements[size++] = elem;
		sort(); // Maintain order after adding
		return true;
	}

	// Method to add an element at a specific index
	public void add(int index, Comparable elem) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		if (size == capacity) {
			expandCapacity();
		}
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = elem;
		size++;
		sort(); // Maintain order after adding
	}

	// Method to remove an element from the list
	public boolean remove(Object elem) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(elem)) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	// Method to remove an element at a specific index
	public Comparable remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		Comparable removedElement = elements[index];
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[--size] = null; // Clear the last element
		return removedElement;
	}

	// Method to clear the list
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	// Method to sort the elements in the list
	private void sort() {
		Comparable tmp;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (elements[i].compareTo(elements[j]) > 0) {
					tmp = elements[i];
					elements[i] = elements[j];
					elements[j] = tmp;
				}
			}
		}
	}

	// Private method to expand the capacity of the elements array
	private void expandCapacity() {
		capacity *= 2;
		Comparable[] newElements = new Comparable[capacity];
		System.arraycopy(elements, 0, newElements, 0, size);
		elements = newElements;
	}

}
