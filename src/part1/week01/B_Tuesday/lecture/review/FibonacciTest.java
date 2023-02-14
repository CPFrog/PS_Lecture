package part1.week01.B_Tuesday.lecture.review;

import java.util.Scanner;

public class FibonacciTest {
//	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
//			dp[i] = fibo(i);
			System.out.printf("fibo(%d)= %d\n", i, fibo(i));
		}
	}

	private static int fibo(int i) {
		if (i < 2)
			return i;
//		else if (dp[i] != 0)
//			return dp[i];
		else
			return fibo(i - 1) + fibo(i - 2);
	}

}
