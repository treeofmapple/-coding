package arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram {

	static final int SIZE_MAX = 12;

	public boolean isAnagramBrute(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		char[] s1 = s.toCharArray();
		char[] s2 = t.toCharArray();

		Arrays.sort(s1);
		Arrays.sort(s2);

		return Arrays.equals(s1, s2);
	}

	public boolean isAnagramHashMap(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Integer> charCount = new HashMap<>();

		for (char ch : s.toCharArray()) {
			charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
		}

		for (char ch : t.toCharArray()) {
			charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
			if (charCount.get(ch) == 0) {
				charCount.remove(ch);
			}
		}

		return charCount.isEmpty();
	}

	public boolean isAnagramFrequencyArray(String s, String t) {
		
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

}
