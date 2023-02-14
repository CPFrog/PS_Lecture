package part1.week01.D_Thursday.WebX;

import java.util.Arrays;

public class NextPermutation {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static int cnt;

	public static void main(String[] args) {
		do {
			cnt++;
			System.out.println(Arrays.toString(p));
		} while (np(n - 1));

		System.out.println("주어진 수열 이후의 다음 순열 개수: " + cnt);
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && p[i - 1] > p[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (p[i - 1] > p[j])
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
