package part1.week02.E_Friday.review;

import java.util.Arrays;

public class FiboTest2 {
	public static void main(String[] args) {
		int n = 30;
		long[] memo = new long[n+1];
		Arrays.fill(memo, 0);
		for (int i = 0; i <= n; i++)
			System.out.println(fibo(i, memo));
	}

	private static long fibo(int n, long[] memo) {
		if (n < 2)
			return memo[n] = n;
		else if (memo[n] != 0)
			return memo[n];
		else
			return memo[n] = fibo(n - 1, memo) + fibo(n - 2, memo);

	}
}
