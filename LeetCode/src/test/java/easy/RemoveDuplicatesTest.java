package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import testutils.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RemoveDuplicatesTest extends TesterRunner {

	private RemoveDuplicates ab;

	@BeforeEach
	void setUp() throws Exception {
		ab = new RemoveDuplicates();
	}

	@Test
	@Order(1)
	void RemoveDuplicatesTestCase1() {
		int a[] = {1,1,2};
		int expected = 2;
		int result = ab.removeDuplicates(a);
		runTestEquals(expected, result);
	}

	@Test
	@Order(2)
	void RemoveDuplicatesTestCase2() {
		int a[] = {0,0,1,1,1,2,2,3,3,4};
		int expected = 5;
		int result = ab.removeDuplicates(a);
		runTestEquals(expected, result);
	}
}
