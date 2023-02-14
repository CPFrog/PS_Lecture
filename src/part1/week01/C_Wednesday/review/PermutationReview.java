package part1.week01.C_Wednesday.review;

import java.util.Arrays;

public class PermutationReview {
	static int[] pick = { 0, 0, 0, 0, 1, 1, 1, 1, 1 };
	static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[] nums;
	static int n, r;

	static int cnt;
	static boolean[] isVisited;

	public static void main(String[] args) {
		n = arr.length;
		r = 5;
		isVisited = new boolean[n];
		nums = new int[r];
		npr(0);
		System.out.println(cnt);
	}

	private static void npr(int place) {
		if (place == r) {
			cnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isVisited[i])
				continue;
			isVisited[i] = true;
			nums[place] = arr[i];
			npr(place + 1);

			nums[place] = 0;
			isVisited[i] = false;
		}
	}
}
