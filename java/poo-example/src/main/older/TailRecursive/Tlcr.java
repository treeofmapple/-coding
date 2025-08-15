package TailRecursive;

public class Tlcr {

	public static void main(String[] args) {
		System.out.println(factorial(12));
		System.out.println(reord(12));
	}
	
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		int x = factorial (n - 1);
		return n * x;
	}
	
	public static int reord (int n) {
		if(n == 1) {
			return 1;
		}
		return n * reord (n - 1);
	}
	
}
