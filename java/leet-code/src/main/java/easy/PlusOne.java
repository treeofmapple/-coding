package easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
    	int n = digits.length;
    	
    	for (int c = digits.length - 1; c >= 0; c--) {
    		if(digits[c] < 9) {
    			digits[c]++;
    			return digits;
    		}
    		digits[c] = 0;
    	}
    	
    	int[] newDigits = new int[n+1];
    	newDigits[0] = 1;
    	return newDigits;
    }

}

