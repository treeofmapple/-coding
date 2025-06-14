package streans;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Mairn {
	static Random random = new Random();	
	public static void main(String[] args) {
		List <Person> people = new ArrayList<>();
		
        String[] names = {
        		"Alice", "Bob", "Charlie", "David", "Eve", 
        		"Frank", "Grace", "Henry", "Ivy", "Jack", 
        		"Kate", "Liam", "Mia", "Noah", "Olivia", 
        		"Peter", "Quinn", "Ryan", "Samantha", "Tom", 
        		"Ursula", "Victor", "Wendy", "Xander", "Yara", "Zoe"};

        for (int i = 0; i < 7; i++) {
            int randomNumber = random.nextInt(names.length);
            people.add(new Person(names[randomNumber], random.nextInt(32) + 9));
        }

        List <Person> older = people.stream()
        		.filter(person -> person.age >= 25)
        		.collect(Collectors.toList());
        
        
        List <Person> sortedList = people.stream()
        		.sorted(Comparator.comparing(person -> person.name))
        		.collect(Collectors.toList());
        
		older.forEach(person -> System.out.println(person.name));
		sortedList.forEach(person -> System.out.println(person.name));
	}
	
	
	static class Person {
		String name;
		int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Red{" +
	                "name='" + name + '\'' +
	                ", value=" + age +
	                '}';
		}

	}	
	
}


