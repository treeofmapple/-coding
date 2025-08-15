package debug;

public class Advc {
	
	public static void main(String[] args) {

		Cat cat1 = new Cat("Kaldarr");
		Cat cat2 = new Cat("Mitro");
		Cat cat3 = new Cat("Galdera");
		
		cat1.setLitterPreference("Fresh Stew");
		cat2.setLitterPreference("Soup");
		cat3.setLitterPreference("Caldo Grouse");
		
		cat1.setAge(4);
		cat2.setAge(5);
		cat3.setAge(1);
		
		System.out.println(cat1.getAge());
		System.out.println(cat2.getAge());
		System.out.println(cat3.getAge());
		
		
		Cat[] cats = new Cat[5];
		
		cats[0] = cat1;
		cats[1] = cat2;
		cats[2] = cat3;
		
	}
		
		
		
}
