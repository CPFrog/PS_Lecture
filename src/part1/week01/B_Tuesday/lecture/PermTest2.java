package part1.week01.B_Tuesday.lecture;

import java.util.Arrays;

public class PermTest2 {
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
		npr(0);
		System.out.println(count);
	}

	private static void npr(int cnt) {
		if (cnt == r) {
			count++;
			for (int i = 0; i < n; i++) {
				if (isVisited[i]) {
					System.out.print(p[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isVisited[i])
				continue;
			isVisited[i] = true;
			nums[cnt] = p[i];
			npr(cnt + 1);
			nums[cnt] = 0;
			isVisited[i] = false;
		}

	}

}
