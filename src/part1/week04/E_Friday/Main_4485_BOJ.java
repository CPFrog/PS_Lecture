package part1.week04.E_Friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int t = 1;
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int map[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			int ans[][] = new int[n][n];
			int dr[] = { 0, 0, 1, -1 };
			int dc[] = { 1, -1, 0, 0 };
			PriorityQueue<Point> q = new PriorityQueue<>();
			q.offer(new Point(0, 0, map[0][0]));
			boolean[][] visited = new boolean[n][n];
			while (!q.isEmpty()) {
				Point cur = q.poll();
				if(visited[cur.row][cur.col]) continue;
				visited[cur.row][cur.col]=true;
				if (ans[cur.row][cur.col] == 0)
					ans[cur.row][cur.col] = cur.value;
				else ans[cur.row][cur.col]=Integer.min(ans[cur.row][cur.col],cur.value);
				for (int i = 0; i < 4; i++) {
					int nr = cur.row + dr[i];
					int nc = cur.col + dc[i];
					if (rangeCheck(n, nr, nc) && !visited[nr][nc]) {
						int tmp = cur.value + map[nr][nc];
						q.offer(new Point(nr, nc, tmp));
					}
				}
			}
//			for (int i = 0; i < n; i++)
//				System.out.println(Arrays.toString(ans[i]));
			sb.append("Problem " + t + ": " + ans[n - 1][n - 1] + "\n");
			n = Integer.parseInt(br.readLine());
			t++;
		}
		System.out.println(sb.toString());
	}

	private static boolean rangeCheck(int n, int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}

	static class Point implements Comparable<Point> {
		int row, col, value;

		public Point(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.value, o.value);
		}

		public void copy(Point p) {
			this.row = p.row;
			this.col = p.col;
			this.value = p.value;
		}
	}
}
