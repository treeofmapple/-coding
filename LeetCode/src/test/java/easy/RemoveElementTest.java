package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import TestUtils.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RemoveElementTest extends TesterRunner {

	private RemoveElement ab;
		
	@BeforeEach
	void setUp() throws Exception {
		ab = new RemoveElement();
	}

	@Test
	@Order(1)
	void RemoveTestCase1() {
		int a[] = {3,2,2,3}, b = 3;
		int expected = 2;
		int result = ab.removeElement(a, b);
		runTestEquals(expected, result);
	}

	@Test
	@Order(2)
	void RemoveTestCase2() {
		int a[] = {0,1,2,2,3,0,4,2}, b = 2;
		int expected = 5;
		int result = ab.removeElement(a, b);
		runTestEquals(expected, result);
	}

}
