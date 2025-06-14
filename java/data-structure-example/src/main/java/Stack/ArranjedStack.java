package Stack;

import java.util.EmptyStackException;

public class ArranjedStack {

	private int topOfStack;
	private Object[] elements;
	private int capacity = 100;

	public ArranjedStack() {
		elements = new Object[capacity];
		topOfStack = -1;
	}

	public boolean empty() {
		return topOfStack == -1;
	}

	public void push(Object elem) {
		topOfStack++;
		resizeCapacity();
		elements[topOfStack] = elem;
	}

	private void resizeCapacity() {
		if (topOfStack == capacity) {
			Object[] newElements = new Object[capacity * 2];
			for (int i = 0; i < capacity; i++)
				newElements[i] = elements[i];
			elements = newElements;
			capacity *= 2;
		}
	}

	public void pop() {
		if (empty())
			throw new EmptyStackException();
		topOfStack--;
	}

	public Object peek() {
		if (empty())
			throw new EmptyStackException();
		return elements[topOfStack];
	}

	public void print() {
		if (this.empty())
			System.out.println("Pilha Vazia");
		else {
			System.out.println("Incio");
			for (int i = 0; i <= topOfStack; i++) {
				System.out.println(elements[i].toString());
			}

			System.out.println("Incio");
		}
	}
}
