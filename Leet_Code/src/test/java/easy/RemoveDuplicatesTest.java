package easy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import testutils.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RemoveDuplicatesTest extends TesterRunner {

	private RemoveDuplicates ab;

	@BeforeEach
	void setUp() throws Exception {
		ab = new RemoveDuplicates();
	}

	@ParameterizedTest
	@MethodSource("provideTestData")
	@Order(1)
	void RemoveDuplicatesTestCase(int[] a, int expected) {
		int result = ab.removeDuplicates(a);
		runTestEquals(expected, result);
	}
	
	private static Stream<Arguments> provideTestData(){
		return Stream.of(
				Arguments.of(new int[] {1,1,2}, 2),
				Arguments.of(new int[] {0,0,1,1,1,2,2,3,3,4}, 5)
		);
	}
	
}
