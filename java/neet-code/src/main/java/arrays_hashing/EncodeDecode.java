package arrays_hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

	public String encode(List<String> strs1) {
		if (strs1.isEmpty()) {
			return "";
		}
		StringBuilder res = new StringBuilder();
		List<Integer> sizes = new ArrayList<>();
		for (String str : strs1) {
			sizes.add(str.length());
		}
		for (int size : sizes) {
			res.append(size).append(',');
		}
		res.append('#');
		for (String str : strs1) {
			res.append(str);
		}
		return res.toString();
	}

	public List<String> decode(String strs1) {
		if (strs1.length() == 0) {
			return new ArrayList<>();
		}
		List<String> res = new ArrayList<>();
		List<Integer> sizes = new ArrayList<>();
		int i = 0;
		while (strs1.charAt(i) != '#') {
			StringBuilder cur = new StringBuilder();
			while (strs1.charAt(i) != ',') {
				cur.append(strs1.charAt(i));
				i++;
			}
			sizes.add(Integer.parseInt(cur.toString()));
			i++;
		}
		i++;
		for (int sz : sizes) {
			res.add(strs1.substring(i, i + sz));
			i += sz;
		}
		return res;
	}

    public String encodeAlt(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decodeAlt(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }

}
