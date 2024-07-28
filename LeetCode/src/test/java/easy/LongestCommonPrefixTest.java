package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import TestUtils.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LongestCommonPrefixTest extends TesterRunner {

	private LongestCommonPrefix ab;
	
	@BeforeEach
	void setUp() throws Exception {
		ab = new LongestCommonPrefix();
	}

	@Test
	@Order(1)
	void LongestCommonPrefixCase1() {
		String[] a = {"flower","flow","flight"}; 
		String expected = "fl";
		String result = ab.longestCommonPrefix(a);
		runTestEquals(expected, result);
	}
	
	@Test
	@Order(2)
	void LongestCommonPrefixCase2() {
		String[] a = {"dog","racecar","car"}; 
		String expected = "";
		String result = ab.longestCommonPrefix(a);
		runTestEquals(expected, result);
	}

}
