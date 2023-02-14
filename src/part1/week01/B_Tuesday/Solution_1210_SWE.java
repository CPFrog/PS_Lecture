package part1.week01.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_SWE {
	static final int n = 100;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1 };
	static int[] dy = { 1, -1, 0 };
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 0, y = 0;
		for (int T = 0; T < 10; T++) {
			ans = 0;
			visited = new boolean[n][n];
			map = new int[n][n];
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			dfs(x, y);
			System.out.println("#" + t + " " + ans);
		}
	}

	static boolean dfs(int x, int y) {
		if (x == 0) {
			ans = y;
			return true;
		}

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && ny < n) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (dfs(nx, ny))
						return true;
					visited[nx][ny] = false;
				}
			}
		}
		return false;
	}

}
