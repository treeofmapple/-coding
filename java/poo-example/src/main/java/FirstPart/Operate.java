package FirstPart;

import Interfaces.FirstPart;
import OperUsers.ComplexNumber;

public class Operate implements FirstPart {

	@Override
	public int[] NumberSwap(int a, int b) {
		int c = a;
		a = b;
		b = c;

		return new int[] { a, b };
	}

	@Override
	public int BinaryTransform(int a) {
		return Integer.parseInt(Integer.toBinaryString(a));
	}

	@Override
	public int FatorialNumber(int a) {
		int result = 1;
		for (int i = 1; i <= a; i++) {
			result *= i;
		}
		return result;
	}

	@Override
	public ComplexNumber add(ComplexNumber n1, ComplexNumber n2) {
		return new ComplexNumber(n1.real + n2.real, n1.image + n2.image);
	}

	@Override
	public int SimpleInterest(int a, int b, int c) {
		return (a * b * c) / 100;
	}

	@Override
	public int[] PascalTriangle(int a) {
		int[] triangle = new int[a * (a + 1) / 2];
		int index = 0;

		for (int i = 0; i < a; i++) {
			int prev = 1;
			for (int j = 0; j <= i; j++) {
				triangle[index++] = prev;
				prev = prev * (i - j) / (j + 1);
			}
		}
		return triangle;
	}

	@Override
	public int Fibonacci(int a) {
		if (a <= 0)
			return 0;

		int[] fib = new int[2 * a + 1];

		fib[0] = 0;
		fib[1] = 1;
		int sum = 0;

		for (int i = 2; i <= 2 * a; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
			if (i % 2 == 0)
				sum += fib[i];
		}
		return sum;
	}

	@Override
	public String[] PyramidPattern(int a) {
	    String[] result = new String[a];
	    int x = 2 * a - 1;
	    for (int i = 0; i < a; i++) {
	        StringBuilder row = new StringBuilder();
	        int stars = 2 * i + 1;
	        int spaces = (x - stars) / 2;

	        for (int j = 0; j < spaces; j++) {
	            row.append(" ");
	        }

	        for (int j = 0; j < stars; j++) {
	            row.append("*");
	        }

	        for (int j = 0; j < spaces; j++) {
	            row.append(" ");
	        }
	        result[i] = row.toString();
	    }

	    return result;
	}
	
	@Override
	public String[] PrintPattern(int a) {
	    if (a < 2) {
	        throw new IllegalArgumentException("a must be at least 2");
	    }

	    String[] result = new String[a];
	    String fullRow = "*".repeat(a);
	    String middleRow = "*" + " ".repeat(a - 2) + "*";

	    for (int i = 0; i < a; i++) {
	        if (i == 0 || i == a - 1) {
	            result[i] = fullRow;
	        } else {
	            result[i] = middleRow;
	        }
	    }
	    return result;
	}

}