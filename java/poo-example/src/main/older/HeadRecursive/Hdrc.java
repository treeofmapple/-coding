package HeadRecursive;

public class Hdrc {
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
		
	}

	public static int factorial (int n) {
		return factorial (n,1);
	}
	
	private static int factorial(int n, int x) {
		if(n == 1) {
			return x;
		}
		return factorial (n - 1, n * x);
	}
	
}
