package part1.week04.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14502_BOJ {
	static int r, c, empties;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int[][] map = new int[r][c];
		ArrayList<Point> empty = new ArrayList<>();
		ArrayList<Point> virus = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				switch (map[i][j]) {
				case 0:
					empty.add(new Point(i, j));
					break;
				case 2:
					virus.add(new Point(i, j));
					break;
				default:
				}
			}
		}
		empties = empty.size() - 3;

		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i < empty.size() - 2; i++) {
			map[empty.get(i).r][empty.get(i).c] = 1;
			for (int j = i + 1; j < empty.size() - 1; j++) {
				map[empty.get(j).r][empty.get(j).c] = 1;
				for (int k = j + 1; k < empty.size(); k++) {
					map[empty.get(k).r][empty.get(k).c] = 1;
					int tmp = bfs(map, virus);
					if (tmp > maxVal) {
						maxVal = tmp;
					}
					map[empty.get(k).r][empty.get(k).c] = 0;
				}
				map[empty.get(j).r][empty.get(j).c] = 0;
			}
			map[empty.get(i).r][empty.get(i).c] = 0;
		}

		System.out.println(maxVal);
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int bfs(int[][] map, ArrayList<Point> viruses) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[r][c];
		for (Point pt : viruses) {
			q.offer(pt);
			visited[pt.r][pt.c] = true;
		}
		int ans = empties;

		int dr[] = { 0, 0, 1, -1 };
		int dc[] = { 1, -1, 0, 0 };
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (rangeCheck(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					if (map[nr][nc] == 0) {
						q.offer(new Point(nr, nc));
						ans--;
					}
				}
			}
		}
		return ans;
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}
}
