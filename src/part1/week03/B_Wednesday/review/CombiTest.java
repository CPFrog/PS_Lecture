package part1.week03.B_Wednesday.review;

import java.util.Arrays;

public class CombiTest {
	static int[] p = { 1, 2, 3, 4, 5, 6 };
	static int n = p.length;
	static int r;
	static int nums[];
	static int count;

	public static void main(String[] args) {
		r = 3;
		nums = new int[r];
		nCr(0, 0);
		System.out.println(count);

	}

	private static void nCr(int start, int cnt) {
		if (cnt == r) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = start; i < n; i++) {
			nums[cnt] = p[i];
			nCr(i + 1, cnt + 1);
		}

	}

}
