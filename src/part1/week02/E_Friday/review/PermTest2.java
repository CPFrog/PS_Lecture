package part1.week02.E_Friday.review;

import java.util.Arrays;

// 비트마스킹
public class PermTest2 {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n, r;
	static int count;
	static boolean[] visited;

	public static void main(String[] args) {
		n = p.length;
		r = 3;
		visited = new boolean[n];
		npr(0, 0, new int[r]);
		System.out.println(count);
	}

	// recursion -> 팩토리얼, 피보나치, nCr ...
	private static void npr(int cnt, int flag, int[] nums) {
		if (cnt == r) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((flag & (1 << i)) != 0)
				continue;
			nums[cnt] = p[i];
			npr(cnt + 1, flag | (1 << i), nums);
		}
	}
}
