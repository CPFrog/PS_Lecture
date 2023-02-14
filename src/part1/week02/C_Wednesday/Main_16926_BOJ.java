package part1.week02.C_Wednesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_BOJ {
	static int[][] arr;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m, r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < r; i++)
			rotate(0, n - 1, 0, m - 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				sb.append(arr[i][j] + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void rotate(int up, int down, int left, int right) {
		if (up >= down || left >= right)
			return;
		rotate(up + 1, down - 1, left + 1, right - 1);
		int curR = up;
		int curC = left;
		int d = 0;
		boolean sw = true;
		int nextVal = arr[curR][curC];
		while (sw) {
			int nextR = curR + dr[d];
			int nextC = curC + dc[d];
			if (nextR < up || nextR > down || nextC < left || nextC > right) {
				d++;
				continue;
			}
			if (nextR == up && nextC == left)
				sw = false;
			int tmp = arr[nextR][nextC];
			arr[nextR][nextC] = nextVal;
			nextVal = tmp;
			curR = nextR;
			curC = nextC;
		}
	}
}
