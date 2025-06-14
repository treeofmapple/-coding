package debug;

public class Cat {
	
	String name;
	String litterPreference;
	int Age;
	
	public Cat(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getLitterPreference() {
		return litterPreference;
	}

	public int getAge() {
		return Age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLitterPreference(String litterPreference) {
		this.litterPreference = litterPreference;
	}

	public void setAge(int age) {
		Age = age;
	}
	
}
