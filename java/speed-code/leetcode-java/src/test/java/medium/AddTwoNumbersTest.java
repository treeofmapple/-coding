package medium;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import constructors.ListNode;
import functions.Others;
import testutils.TesterRunner;

class AddTwoNumbersTest extends TesterRunner {

	private AddTwoNumbers aa;
	private Others othz;

	@BeforeEach
	void setUp() throws Exception {
		aa = new AddTwoNumbers();
		othz = new Others();
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void AddTwoNumberstestCase1(int[] a, int[] b, int[] c) {
		ListNode l1 = othz.setArrayTolist(a);
		ListNode l2 = othz.setArrayTolist(b);
		ListNode result = aa.addTwoNumbersA(l1, l2);

		runTestEquals(Arrays.toString(c), Arrays.toString(othz.setListNodeToArray(result)));
	}

    private static Stream<org.junit.jupiter.params.provider.Arguments> provideIntArrays() {
        return Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(new int[]{}, new int[]{}, new int[]{ 7, 0, 8}),
            org.junit.jupiter.params.provider.Arguments.of(new int[]{ 0 }, new int[]{ 0 }, new int[] { 0 }),
            org.junit.jupiter.params.provider.Arguments.of(new int[]{ 9, 9, 9, 9, 9, 9, 9 }, new int[]{ 9, 9, 9, 9 }, new int[] { 8, 9, 9, 9, 0, 0, 0, 1 })
        );
    }

}
