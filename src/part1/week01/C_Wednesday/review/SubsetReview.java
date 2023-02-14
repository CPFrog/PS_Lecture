package part1.week01.C_Wednesday.review;

import java.util.Arrays;

public class SubsetReview {
	static int[] p = { 1, 2, 3, 4 };
	static int n;

	static int cnt;
	static boolean[] isVisited;

	public static void main(String[] args) {
		n = p.length;
		isVisited = new boolean[n];

	}

	private static void subsets(int cnt, int total) {
		if (cnt == n) {
			cnt++;
			System.out.print("선택 된 원소: ");
			for (int i = 0; i < n; i++) {
				if (isVisited[i])
					System.out.print(p[i] + " ");
			}
			System.out.println();
		}
		System.out.print("선택 안된 원소: ");
		
	}

}
