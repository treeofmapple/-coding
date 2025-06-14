package Complexidade;

import static org.testng.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TimeTestUsingJunit {
	
	private static Complexidade cmp;
	private static MainTests tester;
	private static int[] array;
	
	@BeforeAll
	static void setupAll() {
		cmp = new Complexidade();
		tester = new MainTests();
		array = new int [1000];
		for(int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * 1000);
	}
	
	@Test
	@Order(1)
	void isInTest() {
		int chave = array[500];
		long startTime = System.nanoTime();
		int result = cmp.isIn(chave, array);
		long endTime = System.nanoTime();
		
		long duration = endTime - startTime;
		System.out.println("isIn execution time: " + duration + " ns");
		assertTrue(result != -1, "Element should be found.");
	}
	
	@Test
	@Order(2)
	void isInBinary() {
		
	}
	
	
	
}
