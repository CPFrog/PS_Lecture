package part2.week01.B_220930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17070_BOJ {
	static int n;
	static int[] dr = { 0, 1, 1 }; // 우, 대각, 하
	static int[] dc = { 1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int map[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int dp[][] = new int[n][n];
		dp[0][1] = 1;

		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(0, 1, 0));
		while (!q.isEmpty()) {
			Info cur = q.poll();
			int nr = cur.r + 1;
			int nc = cur.c + 1;
			boolean isRightEmpty = (rangeCheck(cur.r, nc) && map[cur.r][nc] == 0);
			boolean isDiagEmpty = (rangeCheck(nr, nc) && map[nr][nc] == 0);
			boolean isDownEmpty = (rangeCheck(nr, cur.c) && map[nr][cur.c] == 0);
			switch (cur.dir) {
			case 0:
				if (isRightEmpty) {
					dp[cur.r][nc] += dp[cur.r][cur.c];
					q.offer(new Info(cur.r, nc, 0));
					if (isDiagEmpty && isDownEmpty) {
						dp[nr][nc] += dp[cur.r][cur.c];
						q.offer(new Info(cur.r, nc, 1));
					}
				}
				break;
			case 1:
				if (isRightEmpty) {
					dp[cur.r][nc] += dp[cur.r][cur.c];
					q.offer(new Info(cur.r, nc, 0));
					if (isDiagEmpty && isDownEmpty) {
						dp[nr][nc] += dp[cur.r][cur.c];
						q.offer(new Info(nr, nc, 1));
					}
				}
				if (isDownEmpty) {
					dp[nr][cur.c] += dp[cur.r][cur.c];
					q.offer(new Info(nr, cur.c, 2));
				}
				break;
			case 2:
				if (isDownEmpty) {
					dp[nr][cur.c] += dp[cur.r][cur.c];
					q.offer(new Info(nr, cur.c, 2));
					if (isDiagEmpty && isRightEmpty) {
						dp[nr][nc] += dp[cur.r][cur.c];
						q.offer(new Info(nr, nc, 1));
					}
				}
				break;
			}
			for (int[] i : dp)
				System.out.println(Arrays.toString(i));
			System.out.println();
		}
		System.out.println(dp[n - 1][n - 1]);
	}

	private static boolean rangeCheck(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}

	static class Info {
		int r, c, dir;

		public Info(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}
