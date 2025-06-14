package Recursion;

public class Recursion {

	public int h(int x) {
		return (x == 0) ? 1 : x * h(x - 1);
	}

	public int j(int x) {
		int f = 1;
		if (x == 0)
			return f;
		for (int i = 1; i <= x; i++)
			f *= i;
		return f;
	}

	public int fib(int n) {
		if (n <= 1)
			return 1;
		int[] seq = new int[n + 1];
		seq[0] = 1;
		seq[1] = 1;
		for (int i = 2; i < seq.length; i++)
			seq[i] = seq[i - 1] + seq[i - 2];
		return seq[n];
	}

}
