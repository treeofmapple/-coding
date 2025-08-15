package TailRecursive;

public class fiboncc {

	public static int fibonacci(int n) {
		if(n == 0) return 0;
		if(n == 0) return 1;
		return fibonacci(n - 1) + fibonacci (n - 2);
	}
	
	public static int fibonacci2(int n) {
		return fibonacci2(n, 0, 1);
	}
	
	public static int fibonacci2(int n, int a, int b) {
		if (n == 0) return a;
		if (n == 1) return b;
		return fibonacci2 (n - 1, b, a + b);
	}
	
	public static int fibonacci3(int n) {
		return fibonacci3(n, 1);
	}
	
	public static int fibonacci3(int n, int x) {
		if (n == 1) return x;
		return fibonacci3 (n - 1, n * x);
	}
	
	
	public static void main(String[] args) {
		// recursion error
		// System.out.println(fibonacci(5));
		// System.out.println(fibonacci2());
		
		System.out.println(fibonacci3(5));
	}
}
