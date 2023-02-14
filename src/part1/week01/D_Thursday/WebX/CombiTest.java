package part1.week01.D_Thursday.WebX;

import java.util.Arrays;

public class CombiTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static int r;
	static int[] nums;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) {
		r = 3;
		nums = new int[r];
		visited = new boolean[n];
		npr(0);
		System.out.println(count);
	}

	private static void npr(int step) {
		if (step == r) {
			System.out.println(Arrays.toString(nums));
			count++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				nums[step] = p[i];
				npr(step + 1);
				visited[i] = false;
			}
		}

	}
}