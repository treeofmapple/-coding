package easy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import testutils.TesterRunner;

class ClimbingStairsTest extends TesterRunner {

	private ClimbingStairs ab;

	@BeforeEach
	void setUp() throws Exception {
		ab = new ClimbingStairs();
	}

	@ParameterizedTest
	@MethodSource("provideTestData")
	void ClimbingStairsTestCase(int a, int expected) {
		int result = ab.climbStairs(a);
		runTestEquals(expected, result);
	}

	private static Stream<Arguments> provideTestData() {
		return Stream.of(Arguments.of(2, 2), Arguments.of(3, 3));
	}
}
