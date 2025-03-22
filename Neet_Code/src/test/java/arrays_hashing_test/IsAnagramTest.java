package arrays_hashing_test;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import arrays_hashing.IsAnagram;
import test_base.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IsAnagramTest extends TesterRunner {

	private IsAnagram ab;

	@BeforeEach
	void setUp() throws Exception {
		ab = new IsAnagram();
	}

	@Order(1)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void IsAnagramTestBruteCase1(String input1, String input2, boolean expected) {
		Boolean result = ab.isAnagramBrute(input1, input2);
		runTestEquals(expected, result);
	}

	@Order(2)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void IsAnagramTestHashMapCase2(String input1, String input2, boolean expected) {
		Boolean result = ab.isAnagramHashMap(input1, input2);
		runTestEquals(expected, result);
	}

	@Order(3)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void IsAnagramTestFrequencyArrayCase3(String input1, String input2, boolean expected) {
		Boolean result = ab.isAnagramFrequencyArray(input1, input2);
		runTestEquals(expected, result);
	}

	private static Stream<Arguments> provideTestData() {
		return Stream.of(
				Arguments.of("racecar", "carrace", true), 
				Arguments.of("jar", "jam", false));

	}
}