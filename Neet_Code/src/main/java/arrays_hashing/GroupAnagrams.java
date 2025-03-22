package arrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public List<List<String>> groupAnagramsSorting(String[] strs) {
		Map<String, List<String>> res = new HashMap<>();
		for (String s : strs) {
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			String sortedS = new String(charArray);
			res.putIfAbsent(sortedS, new ArrayList<>());
			res.get(sortedS).add(s);
		}

		List<List<String>> result = new ArrayList<>(res.values());
		result.forEach(Collections::sort);
		result.sort((a, b) -> a.get(0).compareTo(b.get(0)));
		return result;
	}

	public List<List<String>> groupAnagramsHashTable(String[] strs) {
		Map<String, List<String>> res = new HashMap<>();
		for (String s : strs) {
			int[] count = new int[26];
			for (char c : s.toCharArray()) {
				if (c >= 'a' && c <= 'z') {
					count[c - 'a']++;
				}
			}
			String key = Arrays.toString(count);
			res.putIfAbsent(key, new ArrayList<>());
			res.get(key).add(s);
		}
		return new ArrayList<>(res.values());
	}

}
