package Stack;

import java.util.EmptyStackException;

public class Stack {

	private StackNode topOfStack;

	private class StackNode {
		private Object element;
		private StackNode next;

		private StackNode(Object e, StackNode n) {
			element = e;
			next = n;
		}
	}

	public Stack() {
		topOfStack = null;

	}

	public boolean empty() {
		return topOfStack == null;
	}

	public void push(Object elem) {
		topOfStack = new StackNode(elem, topOfStack);
	}

	public void pop() {
		if (empty())
			throw new EmptyStackException();
		topOfStack = topOfStack.next;
	}

	public Object peek() {
		if (empty())
			throw new EmptyStackException();
		return topOfStack.element;

	}

	public void print() {
		if (this.empty())
			System.out.println("Pilha Vazia");
		else {
			System.out.println("<-----Início----->");

			StackNode itr = topOfStack;
			while (itr != null) {
				System.out.println(itr.element.toString());
				itr = itr.next;
			}
			System.out.println("<-----Fim----->");
		}
	}
}
