package part1.week01.E_Friday.lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_BOJ {
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] map;
	static int[][] cost;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n + 2][m + 2];
		visited = new boolean[n + 2][m + 2];
		cost = new int[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			for (int j = 1; j <= m; j++)
				map[i][j] = line.charAt(j - 1) - '0';
			Arrays.fill(cost[i - 1], Integer.MAX_VALUE);
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 1, 1 });
		visited[1][1] = true;
		cost[1][1] = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (!visited[nr][nc] && map[nr][nc] == 1) {
					cost[nr][nc] = cost[cur[0]][cur[1]] + map[nr][nc];
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
		System.out.println(cost[n][m]);
	}
}
