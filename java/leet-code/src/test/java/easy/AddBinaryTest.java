package easy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import testutils.TesterRunner;

class AddBinaryTest extends TesterRunner {

	private AddBinary ab;

	@BeforeEach
	void setUp() throws Exception {
		ab = new AddBinary();
	}

	@ParameterizedTest
	@MethodSource("provideTestData")
	void AddBinaryTestCase(String a, String b, String expected) {
		String result = ab.addBinary(a, b);
		runTestEquals(expected, result);
	}

	private static Stream<Arguments> provideTestData() {
		return Stream.of(Arguments.of("11", "1", "100"), Arguments.of("1010", "1011", "10101"));
	}

}
