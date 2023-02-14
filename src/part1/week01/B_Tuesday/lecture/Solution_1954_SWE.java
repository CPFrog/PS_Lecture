package part1.week01.B_Tuesday.lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1954_SWE {
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int dir = 0;
			int map[][] = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(map[i], 0);
			int r = 0, c = 0;
			for (int i = 1; i <= n * n; i++) {
				map[r][c] = i;
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] != 0) {
					dir = (dir + 1) % 4;
					nr = r + dr[dir];
					nc = c + dc[dir];
				}
				r = nr;
				c = nc;
			}
			System.out.println("#" + t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) 
					System.out.print(map[i][j]+" ");
				System.out.println();
			}
		}
	}
}
