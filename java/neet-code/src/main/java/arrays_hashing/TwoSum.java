package arrays_hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSumHashMapOne(int[] nums, int target) {
		Map<Integer, Integer> prevMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int diff = target - num;

			if (prevMap.containsKey(diff)) {
				return new int[] { prevMap.get(diff), i };
			}
			prevMap.put(num, i);
		}

		return new int[] {};
	}

	public int[] twoSumHashMapTwo(int[] nums, int target) {
		Map<Integer, Integer> indices = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			indices.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (indices.containsKey(diff) && indices.get(diff) != i) {
				return new int[] { i, indices.get(diff) };
			}
		}

		return new int[0];
	}

	public int[] twoSumBrute(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[0];
	}
	
}
