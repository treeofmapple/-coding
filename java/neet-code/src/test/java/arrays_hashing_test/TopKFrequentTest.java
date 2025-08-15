package arrays_hashing_test;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import arrays_hashing.TopKFrequent;
import test_base.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TopKFrequentTest extends TesterRunner {

	private TopKFrequent ab;

	@BeforeEach
	void setUp() throws Exception {
		ab = new TopKFrequent();
	}

	@Order(1)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void TopKFrequentSortingTestCase1(int[] num1, int num2, int[] expected) {
		int[] result = ab.topKFrequentSorting(num1, num2);
		runTestEquals(expected, result);
	}

	@Order(2)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void TopKFrequentHeapTestCase2(int[] num1, int num2, int[] expected) {
		int[] result = ab.topKFrequentHeap(num1, num2);
		runTestEquals(expected, result);
	}

	@Order(3)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void TopKFreqeuentBucketSortTestCase3(int[] num1, int num2, int[] expected) {
		int[] result = ab.topKFrequentBucketSort(num1, num2);
		runTestEquals(expected, result);
	}

	private static Stream<Arguments> provideTestData() {
		return Stream.of(
				Arguments.of(new int[] { 1, 2, 2, 3, 3, 3 }, 2, new int[] { 2, 3 }),
				Arguments.of(new int[] { 7, 7 } , 1, new int[] { 7 }));
	}
}
