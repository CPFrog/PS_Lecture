package part1.week04.C_Wednesday;

import java.io.*;
import java.util.*;

public class Main_3055_BOJ {
	static int r, c;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int map[][] = new int[r][c];
		Point hedgehog;
		Queue<Point> waterq = new LinkedList<>();
		Queue<Point> hedgeq = new LinkedList<>();
		Point exit = new Point(0, 0);
		int time = 1;
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				switch (line.charAt(j)) {
				case '.':
					break;
				case 'S':
					map[i][j] = 1;
					hedgeq.offer(new Point(i, j));
					break;
				case 'D':
					map[i][j] = Integer.MAX_VALUE;
					exit = new Point(i, j);
					break;
				case '*':
					map[i][j] = -1;
					for (int idx = 0; idx < 4; idx++) {
						int nr = i + dr[idx];
						int nc = j + dc[idx];
						if (rangeCheck(nr, nc) && map[nr][nc] == 0) {
							map[nr][nc] = -(time + 1);
							waterq.offer(new Point(nr, nc));
						}
					}
					break;
				case 'X':
					map[i][j] = -1;
				}
			}
		}
		System.out.println(bfs(map, hedgeq, waterq) ? map[exit.row][exit.col] - 1 : "KAKTUS");
	}

	private static boolean bfs(int[][] map, Queue<Point> hedgeq, Queue<Point> waterq) {
		int days = 1;
		Queue<Point> nextwater = new LinkedList<>();
		Queue<Point> nexthedge = new LinkedList<>();
		while (++days > 0) {
			while (!hedgeq.isEmpty()) {
				Point cur = hedgeq.poll();
				for (int idx = 0; idx < 4; idx++) {
					int nr = cur.row + dr[idx];
					int nc = cur.col + dc[idx];
					if (rangeCheck(nr, nc)) {
						if (map[nr][nc] == 0) {
							map[nr][nc] = days;
							nexthedge.offer(new Point(nr, nc));
						} else if (map[nr][nc] == Integer.MAX_VALUE) {
							map[nr][nc] = days;
							return true;
						}
					}
				}
			}
			if (nexthedge.isEmpty())
				break;
			hedgeq.addAll(nexthedge);
			nexthedge = new LinkedList<Point>();
			while (!waterq.isEmpty()) {
				Point cur = waterq.poll();
				for (int idx = 0; idx < 4; idx++) {
					int nr = cur.row + dr[idx];
					int nc = cur.col + dc[idx];
					if (rangeCheck(nr, nc) && map[nr][nc] >= 0) {
						if (map[nr][nc] != Integer.MAX_VALUE) {
							map[nr][nc] = -(days + 1);
							nextwater.offer(new Point(nr, nc));
						}
					}
				}
			}
			waterq.addAll(nextwater);
			nextwater = new LinkedList<Point>();
		}
		return false;
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}

	static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point tmp = (Point) obj;
				return this.row == tmp.row && this.col == tmp.col;
			}
			return false;
		}
	}
}
