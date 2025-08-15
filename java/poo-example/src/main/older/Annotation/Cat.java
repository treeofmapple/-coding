package Annotation;

@VeryImportant
public class Cat {

	@ImportantString
	String name;
	int age;
	
	public Cat(String name) {
		this.name = name;
	}
	
	
	@RunImmediatly(times = 3)
	public void meow() {System.out.println("Meow");}
	public void eat() {System.out.println("Munch");}
	
}
