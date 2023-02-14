package part1.week02.E_Friday.review;

import java.util.Arrays;

public class CombiTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n, r;
	static int count;

	public static void main(String[] args) {
		n = p.length;
		r = 3;
		nCr(0,0, new int[r]);
		System.out.println(count);
	}

	// recursion -> 팩토리얼, 피보나치, nCr ...
	private static void nCr(int start, int cnt, int[] nums) {
		if (cnt == r) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = start; i < n; i++) {
			nums[cnt] = p[i];
			nCr(i+1, cnt + 1, nums);
		}

	}
}
