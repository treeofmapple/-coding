package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import TestUtils.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PalindromeTest extends TesterRunner {

	private Palindrome aa;
	
	@BeforeEach
	void setUp() throws Exception {
		aa = new Palindrome();
	}

	@Test
	@Order(1)
	void PalindromeTest1() {
		int a = 121;
		boolean expected = true;
		boolean result = aa.isPalindrome(a);
		runTestEquals(expected, result);
	}

	@Test
	@Order(2)
	void PalindromeTest2() {
		int a = -121;
		boolean expected = false;
		boolean result = aa.isPalindrome(a);
		runTestEquals(expected, result);
	}
	
	@Test
	@Order(3)
	void PalindromeTest3() {
		int a = 10;
		boolean expected = false;
		boolean result = aa.isPalindrome(a);
		runTestEquals(expected, result);
	}
}
