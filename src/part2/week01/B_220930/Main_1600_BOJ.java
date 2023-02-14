package part2.week01.B_220930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_BOJ {
	static int[] horseDr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] horseDc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static int row, col, n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(row > 1 || col > 1 ? go() : 0);
	}

	private static int go() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0, 0));
		boolean visited[][][] = new boolean[row][col][n + 1];
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Point current = q.poll();
			if (current.horseUse < n) { // 말 탐색 횟수가 아직 남아있다면
				// 말 이동 탐색
				for (int i = 0; i < 8; i++) {
					int nr = current.r + horseDr[i];
					int nc = current.c + horseDc[i];
					if (nr == row - 1 && nc == col - 1)
						return current.cost + 1;
					if (rangeCheck(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][current.horseUse + 1]) {
						visited[nr][nc][current.horseUse + 1] = true;
						q.offer(new Point(nr, nc, current.cost + 1, current.horseUse + 1));
					}
				}
			}
			// 원숭이(인접 탐색)
			for (int i = 0; i < 4; i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];
				if (nr == row - 1 && nc == col - 1)
					return current.cost + 1;
				if (rangeCheck(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][current.horseUse]) {
					visited[nr][nc][current.horseUse] = true;
					q.offer(new Point(nr, nc, current.cost + 1, current.horseUse));
				}
			}
		}
		return -1;
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < row && nc >= 0 && nc < col;
	}

	private static class Point {
		int r, c, cost, horseUse;

		public Point(int r, int c, int cost, int horseUse) {
			this.r = r;
			this.c = c;
			this.cost = cost;
			this.horseUse = horseUse;
		}
	}
}
