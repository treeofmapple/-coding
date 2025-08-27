package innerclassz;

public class Mairn {
	
	
	
	
	
	
	
	public static void main(String[] args) {

		Animal myAnimal = new Animal();
		myAnimal.makeNoise();
		
		Animal bigfoot = new Animal( ) {
			@Override
			public void makeNoise() {
				System.out.println("Scream!");
			}
		};
		bigfoot.makeNoise();
		
		Runnable myRun = new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm Running away");
			}
		};
		myRun.run();
	}
}
