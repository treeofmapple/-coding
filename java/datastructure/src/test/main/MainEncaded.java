package test.main;

import lists.EncadedLists;

public class MainEncaded {

	public static void main(String[] args) {
	
		EncadedLists a,b,c,d;
		a = new EncadedLists();
		b = new EncadedLists();
		c = new EncadedLists();
		d = new EncadedLists();
		
		numberInserter(10, a);
		numberInserter(20, b);
		numberInserter(40, c);
		numberInserter(30, d);
		
		a.add(50);
		
		System.out.println(a.size());
		System.out.println(b.size());
		System.out.println(c.size());
		System.out.println(d.size() + "\n");
	
		System.out.println(a.indexOf(50) + "\n");
		
		a.print();
		b.print();
		c.print();
		d.print();
		System.out.println("\n");
		
	}
	
	private static void numberInserter(int a, EncadedLists b) {
		for(int i = 0; i <= a; i++) {
			b.add(i);
		}
	}
}
