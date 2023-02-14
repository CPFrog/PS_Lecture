package part1.week02.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861_SWEA {
	static int n;
	static int[][] map;
	static int[][] memo;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder("");
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
//			map=new int[n][n];
			map = new int[n + 2][n + 2];
			memo = new int[n + 2][n + 2];

			int[] ans = { Integer.MAX_VALUE, 0 };
			for (int r = 1; r <= n; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 1; c <= n; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					memo[r][c] = 1;
				}
			}
			for (int r = 1; r <= n; r++) {
				for (int c = 1; c <= n; c++) {
					int[] tmp = dfs(r, c, 1, map[r][c]);
					if (ans[1] < tmp[1])
						ans = Arrays.copyOf(tmp, 2);
				}
			}
			sb.append("#" + t + " " + ans[1] + " " + ans[0] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int[] dfs(int r, int c, int depth, int minStart) {
		int[] ans = { depth, minStart };
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (map[nr][nc] == map[r][c] + 1) {
				int[] tmp;
				if (minStart > map[nr][nc])
					tmp = dfs(nr, nc, depth + 1, map[nr][nc]);
				else
					tmp = dfs(nr, nc, depth + 1, minStart);
				if (ans[0] < tmp[0])
					ans = tmp;
			}
		}
		return ans;
	}

}
