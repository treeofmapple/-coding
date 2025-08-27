package arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {

	public int longestConsecutiveBrute(int[] nums1) {
		int res = 0;
		Set<Integer> store = new HashSet<>();
		for (int num : nums1) {
			store.add(num);
		}
		for (int num : nums1) {
			int streak = 0, curr = num;
			while (store.contains(curr)) {
				streak++;
				curr++;
			}
			res = Math.max(res, streak);
		}
		return res;
	}

	public int longestConsecutiveSorting(int[] nums1) {
		if (nums1.length == 0) {
			return 0;
		}
		Arrays.sort(nums1);
		int res = 0, curr = nums1[0], streak = 0, i = 0;
		while (i < nums1.length) {
			if (curr != nums1[i]) {
				curr = nums1[i];
				streak = 0;
			}
			while (i < nums1.length && nums1[i] == curr) {
				i++;
			}
			streak++;
			curr++;
			res = Math.max(res, streak);
		}
		return res;
	}

	public int longestConsecutiveHashSet(int[] nums1) {
		Set<Integer> numSet = new HashSet<>();
		for (int num : nums1) {
			numSet.add(num);
		}
		int longest = 0;

		for (int num : numSet) {
			if (!numSet.contains(num - 1)) {
				int length = 1;
				while (numSet.contains(num + length)) {
					length++;
				}
				longest = Math.max(longest, length);
			}
		}
		return longest;
	}

	public int longestConsecutiveHashMap(int[] nums1) {
		Map<Integer, Integer> mp = new HashMap<>();
		int res = 0;
		for (int num : nums1) {
			if (!mp.containsKey(num)) {
				mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);
				mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
				mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));
				res = Math.max(res, mp.get(num));
			}
		}
		return res;
	}
}
