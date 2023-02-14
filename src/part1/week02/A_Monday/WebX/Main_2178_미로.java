package part1.week02.A_Monday.WebX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로 {
	static int n, m;
	static int[][] map;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < m; j++)
				map[i][j] = line[j] - '0';
		}
		bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == n - 1 && cur[1] == m - 1)
				return;
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr, nc))
					continue;
				if (map[nr][nc] == 1 && visited[nr][nc] == 0) {
					visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
				}
			}

		}

	}

	private static boolean check(int nr, int nc) {
		return false;
	}
}
