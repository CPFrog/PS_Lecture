package part1.week03.B_Wednesday.review;

import java.util.Arrays;

public class PrevPermutation {
	static int[] p = { 6, 5, 4, 3, 2, 1 };
	static int n = p.length;
	static int count;

	public static void main(String[] args) {
		do {
			count++;
			System.out.println(Arrays.toString(p));
		} while (np(n - 1));
		System.out.println(count);
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && p[i - 1] < p[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (p[i - 1] < p[j])
			j--;
		swap(i - 1, j);
		int k = size;
		while (i < k)
			swap(i++, k--);
		return true;
	}

	private static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
