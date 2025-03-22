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

import arrays_hashing.EncodeDecode;
import test_base.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EncodeDecodeTest extends TesterRunner {

	private EncodeDecode ab;
	
	@BeforeEach
	void setUp() throws Exception {
		ab = new EncodeDecode();
	}

	@Order(1)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void EncodeDecodeTestCase1(List<String> strs1, List<String> expected) {
		String encode = ab.encode(strs1);
		List<String> result = ab.decode(encode);
		runTestEquals(expected, result);
	}

	@Order(2)
	@ParameterizedTest
	@MethodSource("provideTestData")
	void EncodeDecodeAltTestCase2(List<String> strs1, List<String> expected) {
		String encode = ab.encodeAlt(strs1);
		List<String> result = ab.decodeAlt(encode);
		runTestEquals(expected, result);
	}

	private static Stream<Arguments> provideTestData() {
		return Stream.of(
				Arguments.of(List.of("neet", "code", "love", "you"), List.of("neet", "code", "love", "you")),
				Arguments.of(List.of("we", "say", ".", "yes"), List.of("we", "say", ".", "yes")));
	}
	
}
