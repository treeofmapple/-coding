package easy;

import constructors.ListNode;

public class MergeTwoLists {

	public ListNode mergeTwoListsA(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode();
		ListNode current = dummy;

		ListNode p1 = l1;
		ListNode p2 = l2;

		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				current.next = p1;
				p1 = p1.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}

		if (p1 != null) {
			current.next = p1;
		}
		
		if (p2 != null) {
			current.next = p2;
		}

		return dummy.next;
	}
}
