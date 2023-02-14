package part1.week02.C_Wednesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_BOJ {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			int[][] arr = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			sb.append(getIslands(arr) + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int getIslands(int[][] arr) {
		int cnt = 0;
		int r = arr.length;
		int c = arr[0].length;
		boolean[][] isVisited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 1 && !isVisited[i][j]) {
					bfs(i, j, arr, isVisited);
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void bfs(int r, int c, int[][] map, boolean[][] check) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		check[r][c] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < dr.length; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (rangeCheck(nr, nc, map.length, map[0].length) && map[nr][nc] == 1 && !check[nr][nc]) {
					check[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}

	private static boolean rangeCheck(int nr, int nc, int maxR, int maxC) {
		return nr >= 0 && nr < maxR && nc >= 0 && nc < maxC;
	}
}
