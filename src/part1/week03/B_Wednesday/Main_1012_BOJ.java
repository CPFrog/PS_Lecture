package part1.week03.B_Wednesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_BOJ {
	static int m, n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			boolean[][] land = new boolean[m][n];
			boolean[][] visited = new boolean[m][n];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				land[r][c] = true;
			}

			for (int r = 0; r < m; r++) {
				for (int c = 0; c < n; c++) {
					if (land[r][c])
						System.out.print(1 + " ");
					else
						System.out.println(0 + " ");
				}

			}
			int ans = 0;
			for (int r = 0; r < m; r++) {
				for (int c = 0; c < n; c++) {
					if (land[r][c] && !visited[r][c]) {
						ans++;
						visited[r][c] = true;
						dfs(r, c, land, visited);
					}
				}
			}
			sb.append(ans + "\n");
			T--;
		}
		System.out.println(sb.toString());

	}

	private static void dfs(int r, int c, boolean[][] land, boolean[][] visited) {
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (rangeCheck(nr, nc) && land[nr][nc] && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, land, visited);
			}
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < m && nc >= 0 && nc < n;
	}

}
