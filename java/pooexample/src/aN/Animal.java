package aN;

public abstract class Animal {

	private String name;
	private int healthPoints;
	private int age;
	
	public abstract void makeSound();
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Animal(String name, int healthPoints, int age) {
		this.name = name;
		this.healthPoints = healthPoints;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	
}
