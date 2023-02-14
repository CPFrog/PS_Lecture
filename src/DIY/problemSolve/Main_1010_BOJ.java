package DIY.problemSolve;

import java.util.Scanner;

public class Main_1010_BOJ {
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		dp = new int[30][30];
		for (int t = 0; t < T; t++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			int bigger = left > right ? left : right;
			int smaller = left < right ? left : right;
			System.out.println(combi(bigger, smaller));
		}
	}

	private static int combi(int n, int r) {
		if (dp[n][r] > 0)
			return dp[n][r];

		if (n == r || r == 0) {
			dp[n][r] = 1;
			return 1;
		}
		dp[n][r]=combi(n - 1, r - 1) + combi(n - 1, r);
		return dp[n][r];
	}

}
