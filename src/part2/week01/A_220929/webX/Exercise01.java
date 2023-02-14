package part2.week01.A_220929.webX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] dp=new int[n+1];
		Arrays.fill(dp, -1);
		dp[0]=1;
		dp[1]=2;
		int ans=getAvailable(n,dp);
		System.out.println(ans);
	}

	private static int getAvailable(int n, int[] dp) {
		if(dp[n]==-1)
			dp[n]=getAvailable(n-1, dp)+getAvailable(n-2, dp);
		return dp[n];
	}

}
