#include <algorithm>
#include <iostream>
#include <vector>
#include <unordered_map>

const int MAX_CHAR = 12;

class AreAnagrams {
public: 
	bool areAnagrams(std::string& s1, std::string& s2) {
		std::unordered_map<char, int> charCount;
		for (char ch : s1) {
			charCount[ch] += 1;
		}

		for (char ch : s2) {
			charCount[ch] -= 1;
		}

		for (auto& pair : charCount) {
			if (pair.second != 0) {
				return false;
			}
		}

		return true;
	}

	bool areAnagramsBrute(std::string& s1, std::string& s2) {

		std::sort(s1.begin(), s1.end());
		std::sort(s2.begin(), s2.end());

		return s1 == s2;

	}

	bool areAnagramsArray(std::string& s1, std::string& s2) {

		std::vector<int>freq(MAX_CHAR, 0);

		for (char ch : s1) {
			freq[ch - 'a']++;
		}

		for (char ch : s2) {
			freq[ch - 'a']--;
		}

		for (int count : freq) {
			if (count != 0) {
				return false;
			}
		}

		return true;
	}
};