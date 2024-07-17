package addTwoNumbers;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Constructors.ListNode;
import MainTests.MainTests;
import MainTests.Others;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class addTwoNumbersTest {

	private MainTests ts;
	private addTwoNumbers aa;
	private Others othz;

	@BeforeEach
	void setUp() throws Exception {
		ts = new MainTests();
		aa = new addTwoNumbers();
		othz = new Others();
	}

	@Test
	@Order(1)
	void testCase1() {
		ListNode l1 = othz.setArrayTolist(new int[] {2,4,3});
		ListNode l2 = othz.setArrayTolist(new int[] {5,6,4});
		ListNode result = aa.addTwoNumbers(l1, l2);
		int[] expected = new int[] {7,0,8};

		ts.runTestEquals(Arrays.toString(expected),Arrays.toString(othz.setListNodeToArray(result)), "");
	}

	@Test
	@Order(2)
	void testCase2() {
		ListNode l1 = othz.setArrayTolist(new int[] {0});
		ListNode l2 = othz.setArrayTolist(new int[] {0});
		ListNode result = aa.addTwoNumbers(l1, l2);
		int[] expected = new int[] {0};
		
		ts.runTestEquals(Arrays.toString(expected), Arrays.toString(othz.setListNodeToArray(result)), "");
	}

	@Test
	@Order(3)
	void testCase3() {
		ListNode l1 = othz.setArrayTolist(new int[] {2,4,3});
		ListNode l2 = othz.setArrayTolist(new int[] {5,6,4});
		ListNode result = aa.addTwoNumbers(l1, l2);
		int[] expected = new int[] {7,0,8};
		
		ts.runTestEquals(Arrays.toString(expected), Arrays.toString(othz.setListNodeToArray(result)), "");
	}

}
