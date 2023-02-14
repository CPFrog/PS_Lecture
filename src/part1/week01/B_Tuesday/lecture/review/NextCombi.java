package part1.week01.B_Tuesday.lecture.review;

import java.util.Arrays;

public class NextCombi {
	static int[] p = { 0, 0, 1, 1, 1 };
	static int[] arr = { 1, 2, 3, 4, 5 };
	static int n;
	static int count;

	public static void main(String[] args) {
		n = p.length;
		do {
			count++;
			int[] ans = new int[3];
			for (int i = 0; i < n; i++) {
				if (p[i] != 0)
					System.out.print(arr[i]+" ");
			}
			System.out.println();
		} while (np(n - 1));
		System.out.println(count);
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && p[i - 1] >= p[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (p[i - 1] >= p[j])
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
