package easy;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import constructors.ListNode;
import functions.Others;
import testutils.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MergeTwoListsTest extends TesterRunner {

	private MergeTwoLists ab;
	private Others othz;
	
	@BeforeEach
	void setUp() {
		ab = new MergeTwoLists();
		othz = new Others();
	}

	@Test
	@Order(1)
	void MergeTwoListsCase1() {
		ListNode list1 = othz.setArrayTolist(new int[] {1,2,4});
		ListNode list2 = othz.setArrayTolist(new int[] {1,3,4});
		int[] expected = new int[] {1,1,2,3,4,4};
		ListNode result = ab.mergeTwoListsA(list1, list2);
		
		// Expected // Result // TestName
		runTestEquals(Arrays.toString(expected),Arrays.toString(othz.setListNodeToArray(result)));
	}
	
	@Test
	@Order(2)
	void MergeTwoListsCase2() {
		ListNode list1 = othz.setArrayTolist(new int[] {});
		ListNode list2 = othz.setArrayTolist(new int[] {});
		int[] expected = {};
		ListNode result = ab.mergeTwoListsA(list1, list2);
		
		// Expected // Result // TestName
		runTestEquals(Arrays.toString(expected),Arrays.toString(othz.setListNodeToArray(result)));
	}
	
	@Test
	@Order(3)
	void MergeTwoListsCase3() {
		ListNode list1 = othz.setArrayTolist(new int[] {});
		ListNode list2 = othz.setArrayTolist(new int[] {0});
		int[] expected = {0};
		ListNode result = ab.mergeTwoListsA(list1, list2);
		
		// Expected // Result // TestName
		runTestEquals(Arrays.toString(expected),Arrays.toString(othz.setListNodeToArray(result)));
	}
	
}
