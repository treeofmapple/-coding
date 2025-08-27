package easy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import testutils.TesterRunner;

class FindIndexTest extends TesterRunner {

	private FindIndex ab;
	
	@BeforeEach
	void setUp() throws Exception {
		ab = new FindIndex();
	}

	@ParameterizedTest
	@MethodSource("provideTestData")	
	void FindIndexTestCase(String a, String b, int expected) {
		int result = ab.strStr(a, b);
		runTestEquals(expected, result);
	}

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
            Arguments.of("sadbutsad", "sad", 0),
            Arguments.of("leetcode","leeto", -1)
        );
    }
}
