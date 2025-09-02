package test.main;

import lists.ArrayLists;

public class MainLists2 {

	public static void main(String[] args) {
		System.out.println("Running ArrayLists Operations: ");
		runArrayLists();
		
	}
	
	private static void runArrayLists() {
		ArrayLists a, b, c, d;
		final int[] mac = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		a = new ArrayLists();
		b = new ArrayLists();
		c = new ArrayLists();
		d = new ArrayLists();
		
		// insertData()
		// removeData()
		
		
		// indexOf(Object elem);
		// get(int index);
		// print();
		// size();
		// isEmpty();
		// clear();
		// add
		// remove
		
	}
	
	private void insertData(ArrayLists list, int size, Object element) {
		for (int i = 0; i < size; i++) {
			list.add(element);
		}
	}

	private void insertData(ArrayLists list, int size, int index, Object element) {
		for (int i = 0; i < size; i++) {
			list.add(index, element);
		}
	}
	
	private void removeData(ArrayLists list, int index) {
		list.remove(index);
	}

	private void removeData(ArrayLists list, int index, Object element) {
		for (int i = 0; i < index; i++) {
			list.remove(element);
		}
	}
	
	private Object objectList(int a) {
		final Object[] al = {"a","b","c","d","e","f",
			       "g","h","i","j","k","l",
			       "m","n","o","p","q","r",
			       "s","t","U","V","W","X",
			       "Y","Z"};
		return al[a];
	}

}
