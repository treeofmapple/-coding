package access_modifiers;

public class StaticAndDynamicBinding {

	/*
	 * Static Binding (Early Binding)
	 * 
	 * Static Binding happens at compile time.
	 * 
	 * 
	 * private, static, and final methods.
	 * 
	 * Method Overloading.
	 * 
	 */

	public class Calculator {
		public int add(int a, int b) {
			return a + b;
		}
		
		public int add(int a, int b, int c) {
			return a + b + c;
		}
		
		public double add(double a, double b) {
			return a + b;
		}
		
		public double add(double a, double b, double c) {
			return a + b + c;
		}
	}
	
	/*
	 * 
	 * 
	 * Dynamic Binding happens at run time.
	 * 
	 */

	public class Animal {
		public void makeSound() {
			System.out.println("Animal: makes an sound");
		}
	}
	
	public class Dog extends Animal {
		@Override
		public void makeSound() {
			System.out.println("Dog: makes an sound");
		}
	}
	
	public class Cat extends Animal {
		@Override
		public void makeSound() {
			System.out.println("Cat: makes an sound");
		}
	}
	
}
