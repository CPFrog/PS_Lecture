package part1.week01.C_Wednesday.lecture;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11660_BOJ {
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = (arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]);
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			int res = dp[endR][endC] - dp[startR - 1][endC] - dp[endR][startC - 1] + dp[startR - 1][startC - 1];
			bw.append(res + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
