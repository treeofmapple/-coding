package arrays_hashing;

public class ProductExceptSelf {

	public int[] productExceptSelfBrute(int[] nums1) {
		int n = nums1.length;
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			int prod = 1;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					prod *= nums1[j];
				}
			}
			res[i] = prod;
		}
		return res;
	}

	public int[] productExceptSelfDivision(int[] nums1) {
		int prod = 1, zeroCount = 0;
		for (int num : nums1) {
			if (num != 0) {
				prod *= num;
			} else {
				zeroCount++;
			}
		}
		if (zeroCount > 1) {
			return new int[nums1.length];
		}
		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			if (zeroCount > 0) {
				res[i] = (nums1[i] == 0) ? prod : 0;
			} else {
				res[i] = prod / nums1[i];
			}
		}
		return res;
	}

	public int[] productExceptSelfPrefix(int[] nums1) {
		int n = nums1.length;
		int[] res = new int[n];
		int[] pref = new int[n];
		int[] suff = new int[n];

		pref[0] = 1;
		suff[n - 1] = 1;

		for (int i = 1; i < n; i++) {
			pref[i] = nums1[i - 1] * pref[i - 1];
		}

		for (int i = n - 2; i >= 0; i--) {
			suff[i] = nums1[i + 1] * suff[i + 1];
		}

		for (int i = 0; i < n; i++) {
			res[i] = pref[i] * suff[i];
		}
		return res;
	}

	public int[] productExceptSelfOptimal(int[] nums1) {
		int n = nums1.length;
		int[] res = new int[n];

		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums1[i - 1];
		}
		int postfix = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= postfix;
			postfix *= nums1[i];
		}
		return res;
	}
}
