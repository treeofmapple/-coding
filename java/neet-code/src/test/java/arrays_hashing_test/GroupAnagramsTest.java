package arrays_hashing_test;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import arrays_hashing.GroupAnagrams;
import test_base.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GroupAnagramsTest extends TesterRunner {

	private GroupAnagrams ab;

	@BeforeEach
	void setUp() throws Exception {
		ab = new GroupAnagrams();
	}

	@Order(1)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void GroupAnagramsSortingTestCase1(String[] strs1, List<List<String>> expected) {
		List<List<String>> result = ab.groupAnagramsSorting(strs1);
		runTestEquals(expected, result);
	}

	@Order(2)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void GroupAnagramsHashTableTestCase2(String[] strs1, List<List<String>> expected) {
		List<List<String>> result = ab.groupAnagramsHashTable(strs1);
		runTestEquals(expected, result);
	}

	private static Stream<Arguments> provideTestData() {
		return Stream.of(
				Arguments.of(new String[] { "act", "pots", "tops", "cat", "stop", "hat" },
						List.of(List.of("hat"), List.of("act", "cat"), List.of("stop", "pots", "tops"))),
				Arguments.of(new String[] { "X" }, List.of(List.of("X"))), 
				Arguments.of(new String[] { "" }, List.of(List.of(("")))));
	}

}
