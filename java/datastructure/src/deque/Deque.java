package deque;

public class Deque implements ForcedImplementation {

	private DequeNode front, rear;
	
	private class DequeNode {
		private Object element;
		private DequeNode next;
		private DequeNode(Object e, DequeNode n) {
			element = e;
			next = n;
		}
	}
	
	public Deque() {
		
	}
	
	@Override
	public void popFront() {

	}

	@Override
	public void popBack() {

	}

	@Override
	public void seekFront() {

	}

	@Override
	public void seekBack() {

	}

	@Override
	public void cleanDeck() {

	}

	@Override
	public void checkDeck() {

	}

	@Override
	public void createDeck() {

	}

	@Override
	public void print() {

	}

}
