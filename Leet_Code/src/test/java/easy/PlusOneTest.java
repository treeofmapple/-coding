package easy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import testutils.TesterRunner;

class PlusOneTest extends TesterRunner {
	
	private PlusOne ab; 
	
	@BeforeEach
	void setUp() throws Exception {
		ab = new PlusOne();
	}

	@ParameterizedTest
	@MethodSource("provideTestData")
	void PlusOneTestCase(int[] input, int[] expected) {
		int[] result = ab.plusOne(input);
		runTestEquals(expected, result);
	}

	private static Stream<Arguments> provideTestData(){
		return Stream.of(
				Arguments.of(new int[] {1,2,3}, new int[]{1,2,4}),
				Arguments.of(new int[] {4,3,2,1}, new int[]{4,3,2,2}),
				Arguments.of(new int[] {9}, new int[]{1,0})
		);
	}
	
}
