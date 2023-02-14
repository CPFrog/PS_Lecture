package part1.week02.B_Tuesday.review;

import java.util.Arrays;

public class CombiTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static int r;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) {
		r = 3;
		visited = new boolean[n];
		ncr(0,0, new int[r]);
		System.out.println(cnt);
	}

	private static void ncr(int start, int depth, int[] nums) {
		if (depth == r) {
			cnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				
			}
		}

	}

}
