package part1.week03.B_Wednesday.review;

import java.util.Arrays;

public class PermTest3 {
	static int[] p = { 1, 2, 3, 4, 5, 6 };
	static int n = p.length;
	static int r;
	static int nums[];
	static boolean[] visited;
	static int count;

	public static void main(String[] args) {
		r = 3;
		nums = new int[r];
		visited = new boolean[n];
		npr(0, 0);
		System.out.println(count);

	}

	private static void npr(int cnt, int flag) {
		if (cnt == r) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((flag & (1 << i)) == 0) {
				nums[cnt] = p[i];
				npr(cnt + 1, (flag | (1 << i)));
				nums[cnt] = 0;
			}
		}

	}

}
