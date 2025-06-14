package Abstract;

import java.util.Arrays;

public class tesr {

	private static void Multibox() {
		MultiBox a, b, c, d;
		a = new MultiBox(); // 5
		b = new MultiBox(4); // 10
		c = new MultiBox(15);
		d = new MultiBox();

		for (int i = 0; i < 5; i++)
			a.storeNumber(i);

		for (int i = 0; i <= 5; i++)
			b.storeNumber(i);

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				c.storeNumber(i);
			}
		}

		for (int i = 0; i <= 21; i++) {
			if (i % 3 == 0) {
				d.storeNumber(i);
			}
		}

		System.out.println(Arrays.toString(a.fullList()));
		System.out.println(Arrays.toString(b.fullList()));
		System.out.println(Arrays.toString(c.fullList()));
		System.out.println(Arrays.toString(d.fullList()));

	}
	
	private static void MultiboxAluno() {
		MultiBoxAluno a,b,c,d;
		a = new MultiBoxAluno();
		b = new MultiBoxAluno(4);
		c = new MultiBoxAluno();
		d = new MultiBoxAluno(15);
		
		for(int i = 0; i < 5; i++)
			a.storeAluno(new Aluno());
	
		for(int i = 0; i < 10; i++)
			b.storeAluno(new Aluno());

		for(int i = 0; i <= 8; i++)
			if(i % 2 == 0)
				c.storeAluno(new Aluno());

		for(int i = 0; i < 20; i++)
			d.storeAluno(new Aluno());
		
		System.out.println(Arrays.toString(a.fullList()));
		System.out.println(Arrays.toString(b.fullList()));
		System.out.println(Arrays.toString(c.fullList()));
		System.out.println(Arrays.toString(d.fullList()));
		
		
	}
	
	
	private static void Box() {
		Box a,b,c,d;
		a = new Box();
		b = new Box(2);
		c = new Box();
		d = new Box(5);
		
		
		for(int i = 0; i < 5; i++)
			a.storeElement(new Aluno());
	
		for(int i = 0; i < 10; i++)
			b.storeElement(new Aluno());

		for(int i = 0; i <= 8; i++)
			if(i % 2 == 0)
				c.storeElement(new Aluno());

		for(int i = 0; i < 20; i++)
			d.storeElement(new Aluno());
		
		System.out.println(Arrays.toString(a.fullList()));
		System.out.println(Arrays.toString(b.fullList()));
		System.out.println(Arrays.toString(c.fullList()));
		System.out.println(Arrays.toString(d.fullList()));
		
		
	}
	
	public static void main(String[] args) {
		
		Multibox();  // Numbers
		
		MultiboxAluno();  // Preset Aluno array
		
		System.out.println();
		
		Box(); // This one uses an Object
	}
}
