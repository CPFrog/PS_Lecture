package part1.week02.B_Tuesday.review;

import java.util.Arrays;

public class PrevPermutation {
	static int[] p = { 5, 4, 3, 2, 1 };
	static int n = p.length;
	static int cnt;

	public static void main(String[] args) {
		do {
			cnt++;
			System.out.println(Arrays.toString(p));
		} while (prevp(n - 1));
		System.out.println(cnt);
	}

	private static boolean prevp(int size) {
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
