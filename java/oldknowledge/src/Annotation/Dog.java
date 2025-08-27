package Annotation;

@VeryImportant
public class Dog {
	
	String name;
	int age;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public void bark() {System.out.println("Woof");}
	
	public void eat() {System.out.println("Munch");}
	
}
