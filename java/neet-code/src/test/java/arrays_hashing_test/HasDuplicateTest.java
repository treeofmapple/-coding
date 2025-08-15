package arrays_hashing_test;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import arrays_hashing.HasDuplicate;
import test_base.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HasDuplicateTest extends TesterRunner {

	private HasDuplicate ab;

	@BeforeEach
	void setUp() throws Exception {
		ab = new HasDuplicate();
	}

	@Order(1)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void HasDuplicateTestCase1(int[] nums1, boolean expected) {
		Boolean result = ab.hasDuplicated(nums1);
		runTestEquals(expected, result);
	}

	@Order(2)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void HasDuplicateAltTestCase2(int[] nums1, boolean expected) {
		Boolean result = ab.hasDuplicatedAlt(nums1);
		runTestEquals(expected, result);
	}

	@Order(3)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void HasDuplicateBruteTestCase3(int[] nums1, boolean expected) {
		Boolean result = ab.hasDuplicateBrute(nums1);
		runTestEquals(expected, result);
	}

	@Order(4)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void HasDuplicateSortingTestCase4(int[] nums1, boolean expected) {
		Boolean result = ab.hasDuplicateSorting(nums1);
		runTestEquals(expected, result);
	}

	private static Stream<Arguments> provideTestData() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 3 }, true), Arguments.of(new int[] { 1, 2, 3, 4 }, false));
	}

}
