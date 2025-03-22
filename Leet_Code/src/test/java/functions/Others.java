package functions;

import java.util.ArrayList;
import java.util.List;

import constructors.ListNode;

public class Others {

	public <T> String setArray(T[][] array) {
		return this.printArray(array);
	}

	public ListNode setArrayTolist(int[] arr) {
		return this.arrayToListNode(arr);
	}

	public int[] setListNodeToArray(ListNode node) {
		return this.listNodeToArray(node);
	}

	private <T> String printArray(T[][] array) {
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
	    List<Integer> resultList = new ArrayList<>();
	    while (node != null) {
	        resultList.add(node.val);
	        node = node.next;
	    }
	    return resultList.stream().mapToInt(Integer::intValue).toArray();
	}
}
