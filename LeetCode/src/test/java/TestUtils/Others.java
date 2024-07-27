package TestUtils;

import java.util.Arrays;

import constructors.ListNode;

public class Others {

	public String setArray(int[][] array) {
		return this.printArray(array);
	}

	public ListNode setArrayTolist(int[] arr) {
		return this.arrayToListNode(arr);
	}

	public int[] setListNodeToArray(ListNode node) {
		return this.listNodeToArray(node);
	}

	private String printArray(int[][] array) {
		if (array == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < array.length; i++) {
			sb.append("{");
			if (array[i] != null) {
				for (int j = 0; j < array[i].length; j++) {
					sb.append(array[i][j]);
					if (j < array[i].length - 1) {
						sb.append(", ");
					}
				}
			}
			sb.append("}");
			if (i < array.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}

	private ListNode arrayToListNode(int[] arr) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		for (int num : arr) {
			current.next = new ListNode(num);
			current = current.next;
		}
		return dummy.next;
	}

	private int[] listNodeToArray(ListNode node) {
		int[] result = new int[100];
		int index = 0;
		while (node != null) {
			result[index++] = node.val;
			node = node.next;
		}
		return Arrays.copyOf(result, index);
	}
}
