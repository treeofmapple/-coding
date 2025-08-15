package easy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import testutils.TesterRunner;

class LengthOfLastWordTest extends TesterRunner {

	private LengthOfLastWord ab;
	
	@BeforeEach
	void setUp() throws Exception {
		ab = new LengthOfLastWord();
	}

	@ParameterizedTest
	@MethodSource("provideTestData")
	void SearchInsertTestCase(String a, int expected) {
		int answer = ab.lengthOfLastWord(a);
		runTestEquals(expected, answer);
	}

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
            Arguments.of("Hello World", 5),
            Arguments.of("   fly me   to   the moon  ", 4),
            Arguments.of("luffy is still joyboy", 6)
        );
    }
}
