package medium;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import TestUtils.Others;
import TestUtils.TesterRunner;
import constructors.ListNode;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddTwoNumbersTest extends TesterRunner{

	private AddTwoNumbers aa;
	private Others othz;

	@BeforeEach
	void setUp() throws Exception {
		aa = new AddTwoNumbers();
		othz = new Others();
	}

	@Test
	@Order(1)
	void testCase1() {
		ListNode l1 = othz.setArrayTolist(new int[] {2,4,3});
		ListNode l2 = othz.setArrayTolist(new int[] {5,6,4});
		ListNode result = aa.addTwoNumbersA(l1, l2);
		int[] expected = new int[] {7,0,8};

		runTestEquals(Arrays.toString(expected),Arrays.toString(othz.setListNodeToArray(result)));
	}

	@Test
	@Order(2)
	void testCase2() {
		ListNode l1 = othz.setArrayTolist(new int[] {0});
		ListNode l2 = othz.setArrayTolist(new int[] {0});
		ListNode result = aa.addTwoNumbersA(l1, l2);
		int[] expected = new int[] {0};
		
		runTestEquals(Arrays.toString(expected), Arrays.toString(othz.setListNodeToArray(result)));
	}

	@Test
	@Order(3)
	void testCase3() {
		ListNode l1 = othz.setArrayTolist(new int[] {9,9,9,9,9,9,9});
		ListNode l2 = othz.setArrayTolist(new int[] {9,9,9,9});
		ListNode result = aa.addTwoNumbersA(l1, l2);
		int[] expected = new int[] {8,9,9,9,0,0,0,1};
		
		runTestEquals(Arrays.toString(expected), Arrays.toString(othz.setListNodeToArray(result)));
	}

}
