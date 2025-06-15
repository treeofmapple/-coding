#include <vector>
#include <iostream>
#include <cassert>
#include "hasDuplicate.cpp"

void runDuplicateTest() {

	HasDuplicate obj;

	std::vector<int> nums1 = { 1,2,3,3 };
	std::vector<int> nums2 = { 1,2,3,4 };

	assert(obj.hasDuplicated(nums1) == true);
	assert(obj.hasDuplicated(nums2) == false);
	std::cout << "Test case 1 Passed.\n";

	assert(obj.hasDuplicatedAlt(nums1) == true);
	assert(obj.hasDuplicatedAlt(nums2) == false);
	std::cout << "Test case 2 Passed.\n";

	assert(obj.hasDuplicatedArray(nums1) == true);
	assert(obj.hasDuplicatedArray(nums2) == false);
	std::cout << "Test case 3 Passed.\n";

	assert(obj.hasDuplicatedBrute(nums1) == true);
	assert(obj.hasDuplicatedBrute(nums2) == false);
	std::cout << "Test case 4 Passed.\n";

	assert(obj.hasDuplicatedHashLength(nums1) == true);
	assert(obj.hasDuplicatedHashLength(nums2) == false);
	std::cout << "Test case 5 Passed.\n";

}