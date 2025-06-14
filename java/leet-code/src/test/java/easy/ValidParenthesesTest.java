package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import testutils.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ValidParenthesesTest extends TesterRunner {

	private ValidParentheses ab;
	
	@BeforeEach
	void setUp() throws Exception {
		ab = new ValidParentheses();
	}

	@Test
	@Order(1)
	void ValidTestCase1() {
		String a = "()";
		Boolean expected = true;
		Boolean result = ab.isValid(a);
		runTestEquals(expected, result);
	}

	@Test
	@Order(2)
	void ValidTestCase2() {
		String a = "()[]{}";
		Boolean expected = true;
		Boolean result = ab.isValid(a);
		runTestEquals(expected, result);
	}

	@Test
	@Order(3)
	void ValidTestCase3() {
		String a = "(]";
		Boolean expected = false;
		Boolean result = ab.isValid(a);
		runTestEquals(expected, result);
	}
	
	@Test
	@Order(4)
	void ValidTestCase4() {
		String a = "()[)";
		Boolean expected = false;
		Boolean result = ab.isValid(a);
		runTestEquals(expected, result);
	}

}
