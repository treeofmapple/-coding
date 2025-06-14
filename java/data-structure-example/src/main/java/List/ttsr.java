package List;

public class ttsr {

	private static void ArrayList() {
		ArrayLists a,b,c,d;
		a = new ArrayLists();
		b = new ArrayLists();
		c = new ArrayLists(4);
		d = new ArrayLists(8);
		
		for (int i = 0; i <= 5; i++)
			a.add(i);
		
		for(int i = 0; i <= 12; i++)
			b.add(i);
		
		for(int i = 0; i <= 15; i++)
			c.add(i);
		
		for(int i = 0; i <= 21; i++)
			d.add(i);
		
		a.print();
		b.print();
		c.print();
		d.print();
	}

	private static void EncadedList() {
		EncadedList a,b,c,d;
		int[] mac = {1,2,3,4,5,6};
		Object[] al = {"a","b","c","d","e","f",
				       "g","h","i","j","k","l",
				       "m","n","o","p","q","r",
				       "s","t","U","V","W","X",
				       "Y","Z"};
		
		a = new EncadedList();  // Numbers
		b = new EncadedList();  // Numbers
		c = new EncadedList();  // Object
		d = new EncadedList();  // Object
		
		for (int i = 0; i <= 5; i++)
			a.add(i);
		
		for(int i = 0; i <= 12; i++)
			b.add(i);
		
		for(int i = 0; i < 15; i++)
			c.add(i, al[i]);
		
		for(int i = 0; i < 21; i++)
			d.add(i, al[i]);		
		
		a.print();
		a.remove(4);
		
		b.print();
		b.remove(mac);
		
		c.print();
		c.clear();
		c.print();
		
		d.print();
		d.clear();
		d.print();
		
		a.print();
		b.print();
		
	}

	private static void OrderedList() {
		OrderedList a,b,c,d;
		
		
		a = new OrderedList();
		b = new OrderedList();
		c = new OrderedList(4);
		d = new OrderedList(8);
		
		for (int i = 0; i <= 5; i++)
			a.add(i);
		
		for(int i = 0; i <= 12; i++)
			b.add(i);
		
		for(int i = 0; i <= 15; i++)
			c.add(i);
		
		for(int i = 0; i <= 21; i++)
			d.add(i);
		
	}
	
	public static void main(String[] args) {
		System.out.println("Array List");
		ArrayList();
		System.out.println("\nEncaded List");
		EncadedList();
		System.out.println("\nOrdered List");
		OrderedList();
	}
}
