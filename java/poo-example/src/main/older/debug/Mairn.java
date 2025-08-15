package debug;

public class Mairn {
	
	public static void main(String[] args) {
		int first = 12, 
				second = 5;
		int sum = add(first, second);
		
		System.out.println("The sum is: " + sum);
	}
	
	private static int add (int a, int b) {
		int sum = a + b;
		return sum;
	}

	
	
	
	
}


