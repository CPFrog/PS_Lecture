package part1.week04.C_Wednesday;

import java.io.*;
import java.util.*;

public class Main_16236_BOJ {
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];

		Point curPos = new Point(0, 0, 0);
		int level = 2, exp = 0;
		int sharks = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 9)
					sharks++;
				else if (map[i][j] == 9)
					curPos = new Point(i, j, 0);
			}
		}
		int days = 0;
		while (sharks > 0) {
			Point next = bfs(map, curPos, level);
			if (Objects.isNull(next))
				break;

			days += next.dist;
			curPos.r = next.r;
			curPos.c = next.c;
			sharks--;
			if (++exp >= level) {
				level++;
				exp = 0;
			}
		}
		System.out.println(days);
	}

	private static Point bfs(int[][] map, Point start, int level) {
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		boolean[][] visited = new boolean[n][n];
		visited[start.r][start.c] = true;
		map[start.r][start.c] = 0;
		q.offer(start);
		PriorityQueue<Point> ans = new PriorityQueue<Point>();
		boolean hasFound = false;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (rangeCheck(nr, nc) && !visited[nr][nc] && map[nr][nc] <= level) {
					visited[nr][nc] = true;
					if (map[nr][nc] > 0 && map[nr][nc] < level) {
						ans.offer(new Point(nr, nc, cur.dist + 1));
						hasFound = true;
					} else if (!hasFound) // 가지치기
						q.offer(new Point(nr, nc, cur.dist + 1));
				}
			}
		}
		return !hasFound ? null : ans.peek();
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}

	static class Point implements Comparable<Point> {
		int r, c, dist;

		public Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return this.dist != o.dist ? this.dist - o.dist : (this.r != o.r ? this.r - o.r : this.c - o.c);
		}
	}
}
