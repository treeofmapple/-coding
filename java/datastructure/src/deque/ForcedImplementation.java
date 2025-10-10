package deque;

public interface ForcedImplementation {

	public default void pushFront(Object obj) {
		
	}
	
	public default void pushBack(Object obj) {
		
	}
	
	
	public void popFront();
	
	public void popBack();
	
	public void seekFront();
	
	public void seekBack();
	
	public void cleanDeck();
	
	public void checkDeck();
	
	public void createDeck();
	
	public void print();
	
}
