package arrays_hashing_test;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import arrays_hashing.ProductExceptSelf;
import test_base.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductExceptSelfTest extends TesterRunner {

	private ProductExceptSelf ab;
	
	@BeforeEach
	void setUp() throws Exception {
		ab = new ProductExceptSelf();
	}

	@Order(1)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void ProductExceptSelfBruteTestCase1(int[] nums1, int[] expected) {
		int[] result = ab.productExceptSelfBrute(nums1);
		runTestEquals(expected, result);
	}

	@Order(2)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void ProductExceptSelfDivisionTestCase2(int[] nums1, int[] expected) {
		int[] result = ab.productExceptSelfDivision(nums1);
		runTestEquals(expected, result);
	}
	
	@Order(3)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void ProductExceptSelfPrefixTestCase3(int[] nums1, int[] expected) {
		int[] result = ab.productExceptSelfPrefix(nums1);
		runTestEquals(expected, result);
	}
	
	@Order(4)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void ProductExceptSelfOptimalTestCase4(int[] nums1, int[] expected) {
		int[] result = ab.productExceptSelfOptimal(nums1);
		runTestEquals(expected, result);
	}
	
	private static Stream<Arguments> provideTestData() {
		return Stream.of(
				Arguments.of(new int[] { 1, 2, 4, 6 }, new int[] { 48, 28, 12, 8 }),
				Arguments.of(new int[] { -1, 0, 1, 2, 3 }, new int[] { 0, -6, 0, 0, 0 }));
	}
	
}

