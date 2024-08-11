package easy;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import testutils.TesterRunner;

class SearchInsertTest extends TesterRunner{

	private SearchIndex ab;
	
	@BeforeEach
	void setUp() throws Exception {
		ab = new SearchIndex();
	}

	@ParameterizedTest
	@MethodSource("provideTestData")
	void SearchInsertTestCase(int[] a, int b, int expected) {
		runTestEquals(expected, ab.searchInsert(a, b));
	}

	
    private static Stream<Arguments> provideTestData() {
        return Stream.of(
            Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),
            Arguments.of(new int[]{1, 3, 5, 6}, 2, 1),
            Arguments.of(new int[]{1, 3, 5, 6}, 7, 4)
        );
    }
}
