package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import TestUtils.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TwoSumTest extends TesterRunner {
	
	private TwoSum aa;

	@BeforeEach
	void setUp() {
		aa = new TwoSum();
	}
	
	@Test
	@Order(1)
	void twoSumCase1() {

		int [] nums = {2,7,11,15};
		int [] expected = {0,1}; 
		int [] result = aa.twoSum(nums, 9);
		
		// Expected // Result
		runTestEquals(expected, result);
	}

	@Test
	@Order(2)
	void twoSumCase2() {

		int [] nums = {3,2,4};
		int [] expected = {1,2}; 
		int [] result = aa.twoSum(nums, 6);
		
		// Expected // Result
		runTestEquals(expected, result);
	}
	
	@Test
	@Order(3)
	void twoSumCase3() {

		int [] nums = {3,3};
		int [] expected = {0,1}; 
		int [] result = aa.twoSum(nums, 6);
		
		// Expected // Result
		runTestEquals(expected, result);
	}
	
}
