package easy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import testutils.TesterRunner;

class SquirtxTest extends TesterRunner {

	private Squirtx ab;

	@BeforeEach
	void setUp() throws Exception {
		ab = new Squirtx();
	}

	@ParameterizedTest
	@MethodSource("provideTestData")
	void SquirtxTestCase(int a, int expected) {
		int result = ab.mySqrt(a);
		runTestEquals(expected, result);
	}

	private static Stream<Arguments> provideTestData() {
		return Stream.of(Arguments.of(4, 2), Arguments.of(8, 2));
	}
}
