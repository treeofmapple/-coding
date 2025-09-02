package access_modifiers;

public class MainBiding extends StaticAndDynamicBinding {

	public static void main(String[] args) {
		staticBiding();
		dynamicBiding();
	}

	private static void staticBiding() {
		StaticAndDynamicBinding outer = new StaticAndDynamicBinding();
		Calculator ar = outer.new Calculator();
		// Calculator az = new MainBiding().new Calculator();
		int a = 1, b = 2, c = 3;
		double ab = 1, ac = 2, ad = 3;
		System.out.println(ar.add(a, b) + "\n" + ar.add(a, b, c));
		System.out.println(ar.add(ab, ac) + "\n" + ar.add(ab, ac, ad));
	}

	private static void dynamicBiding() {
		StaticAndDynamicBinding outer = new StaticAndDynamicBinding();
		Animal myAnimal1 = outer.new Dog();
		Animal myAnimal2 = outer.new Cat();
		myAnimal1.makeSound();
		myAnimal2.makeSound();
	}

}
