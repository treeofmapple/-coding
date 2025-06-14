package Others;

public class testing {

	private static void ShellSort(int[] array) {
		int n = array.length;
		int iteration = 1; // Variable to keep track of iteration count
		for (int gap = n / 2; gap > 0; gap /= 2) {
			boolean swapped = false;
			for (int i = gap; i < n; i++) {
				int temp = array[i];
				int j;
				for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
					array[j] = array[j - gap];
					swapped = true; // Set swapped to true whenever a swap is made
				}
				array[j] = temp;
			}
			System.out.println("Iteration " + iteration + ": " + arrayToString(array));
			iteration++;
		}
	}

	public static String arrayToString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i < arr.length - 1) sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] array = {12, 34, 54, 2, 3, 1, 6, 7, 9, 45};
		System.out.println("Initial array: " + arrayToString(array));
		ShellSort(array);
	}
}
