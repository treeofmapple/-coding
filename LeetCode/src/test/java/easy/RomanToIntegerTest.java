package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import TestUtils.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RomanToIntegerTest extends TesterRunner {

	private RomanToInteger aa;
	
	@BeforeEach
	void setUp() throws Exception {
		aa = new RomanToInteger();
	}

	@Test
	@Order(1)
	void RomanToIntegerTest1() {
		String a = "III";
		int expected = 3;
		int result = aa.romanToInt(a);
		runTestEquals(expected,result);
	}

	@Test
	@Order(2)
	void RomanToIntegerTest2() {
		String a = "LVIII";
		int expected = 58;
		int result = aa.romanToInt(a);
		runTestEquals(expected,result);
	}
	
	@Test
	@Order(3)
	void RomanToIntegerTest3() {
		String a = "MCMXCIV";
		int expected = 1994;
		int result = aa.romanToInt(a);
		runTestEquals(expected,result);
	}
	
}
