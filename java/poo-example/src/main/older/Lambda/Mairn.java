package Lambda;

public class Mairn {
	
	static void printThing(Printable thing) {
		thing.print();
	}
	
	static void printThing2(Printable2 thing) {
		thing.print("!");
	}
	
	static void printThing3(Printable3 thing) {
		thing.print("!","!");
	}
	
	static void printThing4(Printable4 thing) {
		thing.print("");
	}	
	
	public static void main(String[] args) {

		Cat myCat = new Cat();
		printThing( () -> {System.out.println("Meow");});
		printThing(() -> System.out.println("Meow"));
		
		Printable ABC = () -> System.out.println("Meow");
		printThing(ABC);
		
		Printable2 abcs = (s) -> System.out.println("Meow" + s);
		printThing2(abcs);
		
		Printable3 dolt = (r, s) -> System.out.println("yea"+ r + " "+ s);
		printThing3(dolt);
		
		Printable4 elf = (s) ->  "meow" + s;
		printThing4(elf);

		
	}

	
	
}
