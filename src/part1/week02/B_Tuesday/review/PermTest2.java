package part1.week02.B_Tuesday.review;

import java.util.Arrays;

public class PermTest2 {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static int r;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) {
		r = 3;
		visited = new boolean[n];
		npr(0, 0, new int[r]);
		System.out.println(cnt);
	}

	private static void npr(int depth, int flag, int[] nums) {
		if (depth == r) {
			cnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((flag & (1 << i)) != 0)
				continue;
			nums[depth] = p[i];
			npr(cnt + 1, flag | (1 << i), nums);
			nums[depth] = 0;
		}

	}

}
