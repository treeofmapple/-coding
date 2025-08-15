package easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	
    	if(strs.length == 0)
    		return "";
    	
    	if(strs.length == 1)
    		return strs[0];
    	
        Arrays.sort(strs);
        
        int end = Math.min(strs[0].length(), strs[strs.length-1].length());
        int i = 0;
        
        while(i < end && strs[0].charAt(i) == strs[strs.length-1].charAt(i))
        	i++;
        
        String pre = strs[0].substring(0, i);
        return pre;
    }
}


// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters.