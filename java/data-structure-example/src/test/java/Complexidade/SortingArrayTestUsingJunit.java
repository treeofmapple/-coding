package Complexidade;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import List.ArrayLists;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SortingArrayTestUsingJunit {

	private static MainTests tester;
	private static int arraysize = 32;
	private static int[] expected = new int[arraysize];
	
	@BeforeAll
	static void setupAll() {
		for (int i = 0; i <= expected.length - 1; i++)
			expected[i] =+ (i + 1);
		
		int[] Array = {1,2,3,4,5,6,7,8,9,10};
		int[] shuffled = new int[Array.length];
		Random red = new Random();
		System.arraycopy(Array, 0, shuffled, 0, Array.length);
		
		for (int i = shuffled.length - 1; i > 0; i--) {
			int j = red.nextInt(i+1);
			int temp = shuffled[i];
			shuffled[i] = shuffled[j];
			shuffled[j] = temp;
		}
	}

	@Test
	@Order(1)
	void ArrayListIterationsTest() {
		ArrayLists a;
		// int[] result = a.add();

		// expected, result, testName

		// tester.runTestEquals(expected,result,"");
	}

}
