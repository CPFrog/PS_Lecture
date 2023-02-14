package part1.week03.B_Wednesday.review;

import java.util.ArrayList;
import java.util.Arrays;

public class PermTest2 {
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
		npr(0, new ArrayList<String>());
		System.out.println(count);

	}

	private static void npr(int cnt, ArrayList<String> nums) {
		if (cnt == r) {
			count++;
			System.out.println(Arrays.toString(nums.toArray()));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				nums.add(p[i] + "");
				npr(cnt + 1, nums);
				nums.remove(p[i] + "");
				visited[i] = false;
			}
		}

	}

}
