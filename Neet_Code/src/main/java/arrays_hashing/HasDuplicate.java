package arrays_hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HasDuplicate {

	public boolean hasDuplicated(int[] nums) {
		Set<Integer> setnum = new HashSet<>();
		for (int num : nums) {
			if (setnum.contains(num)) {
				return true;
			}
			setnum.add(num);
		}
		return false;
	}

	public boolean hasDuplicatedAlt(int[] nums) {
		Set<Integer> setnum = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!setnum.add(nums[i])) {
				return true;
			}
		}
		return false;

		// chatgpt model
	}

	public boolean hasDuplicateBrute(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasDuplicateSorting(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				return true;
			}
		}
		return false;
	}

	public boolean hasDuplicateLength(int[] nums) {
		return Arrays.stream(nums).distinct().count() < nums.length;
	}

}
