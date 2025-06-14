package arrays_hashing_test;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import arrays_hashing.TwoSum;
import test_base.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TwoSumTest extends TesterRunner {

	private TwoSum ab;

	@BeforeEach
	void setUp() throws Exception {
		ab = new TwoSum();
	}

	@Order(1)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void TwoSumHashMapTestCase1(int[] nums1, int num2, int[] expected) {
		int[] result = ab.twoSumHashMapOne(nums1, num2);
		runTestEquals(expected, result);
	}

	@Order(2)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void TwoSumHashMapTwoTestCase2(int[] nums1, int num2, int[] expected) {
		int[] result = ab.twoSumHashMapTwo(nums1, num2);
		runTestEquals(expected, result);
	}

	@Order(3)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void TwoSumBruteTestCase3(int[] nums1, int num2, int[] expected) {
		int[] result = ab.twoSumBrute(nums1, num2);
		runTestEquals(expected, result);
	}

	private static Stream<Arguments> provideTestData() {
		return Stream.of(
				Arguments.of(new int[] { 3, 4, 5, 6 }, 7, new int[] { 0, 1 }),
				Arguments.of(new int[] { 4, 5, 6 }, 10, new int[] { 0, 2 }),
				Arguments.of(new int[] { 5, 5 }, 10, new int[] { 0, 1 }));
	}

}
