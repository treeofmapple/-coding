package Abstract;

import java.util.Random;


public class MultiBoxAluno {
	private Aluno[] elements;
	private int capacity;
	private int size;

	public MultiBoxAluno() {
		size = 0;
		capacity = 5;
		elements = new Aluno[capacity];
	}

	public MultiBoxAluno(int capacity) {
		size = 0;
		this.capacity = capacity;
		elements = new Aluno[capacity];
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void storeAluno(Aluno element) {
		reziseIfNeeds();
		elements[size] = element;
		size++;
	}

	public Aluno giveAluno() {
		if (isEmpty())
			return null;
		Random gen = new Random();
		return elements[gen.nextInt(size)];
	}
	
	public Aluno[] fullList() {
		return elements;
	}

	private void reziseIfNeeds() {
		if (size == capacity) {
			capacity *= 2;
			Aluno[] newElements = new Aluno[capacity];
			for (int i = 0; i < size; i++)
				newElements[i] = elements[i];
			elements = newElements;
		}
	}
}
