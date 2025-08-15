#include <unordered_set>
#include <algorithm>

class HasDuplicate {
	public: bool hasDuplicated(std::vector<int>& nums) {
		std::unordered_set<int> seen;
		for (int i = 0; i < seen.size(); i++) {
			if (!seen.insert(nums[i]).second) {
				return true;
			}
		}
		return false;
	}

	public: bool hasDuplicatedAlt(std::vector<int>& nums) {
		std::unordered_set<int> seen;
		for (int num : nums) {
			if (seen.count(num)) {
				return true;
			}
			seen.insert(num);
		}
		return false;
	}

	public: bool hasDuplicatedBrute(std::vector<int>& nums) {
		for (int i = 0; i < nums.size(); i++) {
			for (int j = i + 1; j < nums.size(); j++) {
				if (nums[i] == nums[j])
				{
					return true;
				}
			}

		}
		return false;
	}

	public: bool hasDuplicatedArray(std::vector<int>& nums) {
		sort(nums.begin(), nums.end());
		for (int i = 1; i < nums.size(); i++) {
			if (nums[i] == nums[i - 1]) {
				return true;
			}
		}
		return false;
	}

	public: bool hasDuplicatedHashLength(std::vector<int>& nums) {
		return std::unordered_set<int>(nums.begin(), nums.end()).size() < nums.size();
	}

};