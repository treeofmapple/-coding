package List;

import java.util.Arrays;

public class EncadedList {

	private ListNode head;
	private ListNode tail;
	private ListNode previous;
	private int size;

	private class ListNode {
		private Object element;
		private ListNode next;

		private ListNode(Object e, ListNode n) {
			element = e;
			next = n;
		}
	}

	public EncadedList() {
		size = 0;
		head = tail = previous = null;
	}

	public boolean add(Object elem) {
		ListNode newElement = new ListNode(elem, null);
		if (head == null)
			head = newElement;
		else
			tail.next = newElement;
		tail = newElement;
		size++;
		return true;
	}

	public int indexOf(Object elem) {
		ListNode itr = head;
		previous = null;
		for (int i = 0; i < size; i++) {
			if (itr.element.equals(elem)) {
				return i;
			} else {
				previous = itr;
				itr = itr.next;
			}
		}
		previous = null;
		return -1;
	}

	public Object get(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("Index=" + index + " e Size=" + size);
		else {
			if (index == 0)
				return head.element;
			findPrevious(index);
			return previous.next.element;
		}
	}

	private void findPrevious(int index) {
		ListNode itr = head;
		previous = null;
		for (int i = 0; i < size; i++) {
			if (i == index)
				return;
			previous = itr;
			itr = itr.next;
		}
		return;
	}

	public void print() {
		if (size == 0)
			System.out.println("<----Lista Vazia---->");
		else {
			System.out.println("<----Início---->");
			ListNode itr = head;
			while (itr != null) {
				System.out.print(itr.element + (itr.next == null ? "" : ", "));
				itr = itr.next;
			}
			System.out.println("\nSize of list: " + size());
			System.out.println("<----Fim---->");
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void clear() {
		head = tail = null;
		size = 0;
	}

	public void add(int index, Object elem) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index=" + index + " e Size=" + size);
		else {
			if (index == 0) {
				if (head == null) {
					ListNode newElement = new ListNode(elem, null);
					head = tail = newElement;
				} else {
					ListNode newElement = new ListNode(elem, head);
					head = newElement;
				}
			} else {
				findPrevious(index);
				ListNode newElement = new ListNode(elem, previous.next);
				previous.next = newElement;
				if (newElement.next == null)
					tail = newElement;
			}
		}
		size++;
	}

	public boolean remove(Object elem) {
		int index = indexOf(elem);
		if (index < 0)
			return false;
		remove(index);
		return true;
	}

	public Object remove(int index) {
		Object toBeDeleted;
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index=" + index + " e Size=" + size);
		else {
			if (index == 0) {
				toBeDeleted = head.element;
				if (head == tail)
					head = tail = null;
				else
					head = head.next;
			} else {
				findPrevious(index);
				toBeDeleted = previous.next.element;
				if (previous.next == tail)
					tail = previous;
				previous.next = previous.next.next;
			}
			size--;
		}
		return toBeDeleted;
	}

	public boolean remove(Object[] elems) {
		int[] indices = indexOf(elems);
		if (indices.length == 0)
			return false;
		remove(indices);
		return true;
	}

	public Object[] remove(int[] indices) {
		Arrays.sort(indices);
		Object[] removedElements = new Object[indices.length];
		for (int i = indices.length - 1; i >= 0; i--) {
			removedElements[i] = remove(indices[i]);
		}
		return removedElements;
	}

	public int[] indexOf(Object[] elems) {
		int[] tempIndices = new int[elems.length];
		int count = 0;
		for (Object elem : elems) {
			int index = indexOf(elem);
			if (index != -1) {
				tempIndices[count++] = index;
			}
		}
		int[] indices = new int[count];
		System.arraycopy(tempIndices, 0, indices, 0, count);
		return indices;
	}

}
