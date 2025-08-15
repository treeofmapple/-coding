package FirstPart;

import java.util.Arrays;

import Interfaces.SecondPart;

public class Operate2 implements SecondPart {

	@Override
	public int ArraySum(int[] a) {
		int sum = 0, i;
		for (i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	@Override
	public int LargestElement(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	@Override
	public int[][] TransposeMatrix(int[][] a, int b) {
		int temp[][] = new int[b][b], i, j;
		for (i = 0; i < b; i++)
			for (j = 0; j < b; j++)
				temp[i][j] = a[j][i];

		return temp;
	}

	@Override
	public int[] ArrayRotation(int[] a, int b) {
		int temp[] = new int[b];
		int arl = a.length;

		for (int i = 0; i < b; i++) {
			temp[i] = a[i];
		}

		for (int i = b; i < arl; i++) {
			a[i - b] = a[i];
		}

		for (int i = 0; i < b; i++) {
			a[arl - b + i] = temp[i];
		}

		return a;
	}

	@Override
	public int[] RemoveDuplicated(int[] a) {
		int arl = a.length;
		if (arl <= 1)
			return a;

		int[] temp = new int[arl];
		int j = 0;
		for (int i = 0; i < arl - 1; i++) {
			if (a[i] != a[i + 1])
				temp[j++] = a[i];
		}
		temp[j++] = a[arl - 1];

		int[] result = Arrays.copyOf(temp, j);
		return result;
	}

	@Override
	public int[] RemoveOccurencies(int[] a, int b) {
		int index = 0;
		for (int i = 0; i < a.length; i++)
			if (a[i] != b)
				a[index++] = a[i];

		return Arrays.copyOf(a, index);
	}

}
