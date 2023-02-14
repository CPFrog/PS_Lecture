package part1.week01.B_Tuesday.lecture.review;

import java.util.Arrays;

public class PrevPermutation {
	static int[] p = { 5, 4, 3, 2, 1 };
	static int n;
	static int count;

	public static void main(String[] args) {
		n = p.length;
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
		int tmp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = tmp;
		int k = size;
		while (i < k) {
			tmp = p[i];
			p[i++] = p[k];
			p[k--] = tmp;
		}
		return true;
	}

}
