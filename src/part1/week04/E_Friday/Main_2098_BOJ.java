package part1.week04.E_Friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2098_BOJ {
	static int n;
	static int[][] map, dp;
	static final int INF=Integer.MAX_VALUE/100; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[1 << n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(tsp(0, 1));
	}

	private static int tsp(int cur, int flag) {
		if (flag == (1 << n) - 1)
			return map[cur][0] > 0 ? map[cur][0]:INF;
		int ans=dp[flag][cur];
		if (ans == 0) {
			ans = INF;
			for (int i = 0; i < n; i++) {
				if ((flag & (1 << i)) == 0 && map[cur][i] > 0) {
					ans = Integer.min(ans, tsp(i, flag | (1 << i)) + map[cur][i]);
				}
			}
			dp[flag][cur]=ans;
		}
		return ans;
	}
}
