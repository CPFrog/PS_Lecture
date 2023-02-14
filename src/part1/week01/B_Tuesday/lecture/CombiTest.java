package part1.week01.B_Tuesday.lecture;

import java.util.Arrays;

public class CombiTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static int r;
	static int count;
	static boolean[] isVisited;
	static int[] nums;

	public static void main(String[] args) {
		r = 3;
		nums = new int[r];
		isVisited = new boolean[n];
		ncr(0, 0);
		System.out.println(count);
	}

	private static void ncr(int start, int cnt) {
		if (cnt == r) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = start; i < n; i++) {
			isVisited[i] = true;
			nums[cnt] = p[i];
			ncr(i + 1, cnt + 1);
			nums[cnt] = 0;
			isVisited[i] = false;
		}

	}

}
