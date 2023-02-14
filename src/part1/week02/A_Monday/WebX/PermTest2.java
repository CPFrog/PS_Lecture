package part1.week02.A_Monday.WebX;

import java.util.Arrays;

public class PermTest2 {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static int r;
	static int count;
	static int[] nums;
	static boolean[] visited;

	public static void main(String[] args) {
		r = 3;
		nums = new int[r];
		visited = new boolean[n];
		perm(0, 0);
		System.out.println(count);
	}

	// 비트마스크 방식으로 할 때 (DFS+DP)
	private static void perm(int flag, int cnt) {
		if (cnt == r) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((flag & (1 << i)) != 0)
				continue;
//			System.out.println("flag: "+ Integer.toBinaryString(flag) +",i: "+ i+", cnt: "+cnt);
			nums[cnt] = p[i];
			perm((flag | (1 << i)), cnt + 1);
			nums[cnt] = 0;
		}
	}

}
