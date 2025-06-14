package arrays_hashing_test;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import arrays_hashing.LongestConsecutive;
import test_base.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LongestConsecutiveTest extends TesterRunner {

	private LongestConsecutive ab;
	
	@BeforeEach
	void setUp() throws Exception {
		ab = new LongestConsecutive();
	}

	@Order(1)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void LongestConsecutiveBruteTestCase1(int[] nums1, int expected) {
		int result = ab.longestConsecutiveBrute(nums1);
		runTestEquals(expected, result);
	}
	
	@Order(2)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void LongestConsecutiveSortingTestCase2(int[] nums1, int expected) {
		int result = ab.longestConsecutiveSorting(nums1);
		runTestEquals(expected, result);
	}
	
	@Order(3)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void LongestConsecutiveHashSetTestCase3(int[] nums1, int expected) {
		int result = ab.longestConsecutiveHashSet(nums1);
		runTestEquals(expected, result);
	}
	
	@Order(4)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void LongestConsecutiveHashMapTestCase4(int[] nums1, int expected) {
		int result = ab.longestConsecutiveHashMap(nums1);
		runTestEquals(expected, result);
	}
	
	private static Stream<Arguments> provideTestData() {
		return Stream.of(
				Arguments.of(new int[] { 2, 20, 4, 10, 3, 4, 5 }, 4),
				Arguments.of(new int[] { 0, 3, 2, 5, 4, 6, 1, 1 }, 7));
	}
}
