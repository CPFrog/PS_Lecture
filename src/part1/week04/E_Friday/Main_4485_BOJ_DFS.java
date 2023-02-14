package part1.week04.E_Friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_BOJ_DFS {
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
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
			
			dfs(map, ans, 0,0);
//			for (int i = 0; i < n; i++)
//				System.out.println(Arrays.toString(ans[i]));
			sb.append("Problem " + t + ": " + ans[n - 1][n - 1] + "\n");
			n = Integer.parseInt(br.readLine());
			t++;
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int[][] map, int[][] ans, int i, int j) {
		
		
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
