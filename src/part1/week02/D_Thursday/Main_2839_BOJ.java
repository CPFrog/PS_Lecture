package part1.week02.D_Thursday;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2839_BOJ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] dp = new int[n >= 5 ? n + 1 : 6];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[3] = 1;
		dp[5] = 1;
		for (int i = 6; i <= n; i++) {
			int curMin = Integer.MAX_VALUE;
			if (dp[i - 3] != -1 && curMin > dp[i - 3] + 1)
				curMin = dp[i - 3] + 1;
			if (dp[i - 5] != -1 && curMin > dp[i - 5] + 1)
				curMin = dp[i - 5] + 1;
			if (curMin != Integer.MAX_VALUE)
				dp[i] = curMin;
		}
		System.out.println(dp[n]);
	}

}
