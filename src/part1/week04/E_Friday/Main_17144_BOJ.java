package part1.week04.E_Friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144_BOJ {
	static int r, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[][] cur = new int[r][c];
		int[][] vaccum = new int[2][2];
		int vidx = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				cur[i][j] = Integer.parseInt(st.nextToken());
				if (cur[i][j] == -1) {
					vaccum[vidx][0] = i;
					vaccum[vidx++][1] = j;
				}
			}
		}
		for (int i = 0; i < t; i++) {
			spread(cur);
			for(int j=0;j<r;j++)
				System.out.println(Arrays.toString(cur[j]));
			System.out.println();
			uprotate(cur, vaccum[0][0], vaccum[0][1]);
			downrotate(cur, vaccum[1][0], vaccum[1][1]);
			for(int j=0;j<r;j++)
				System.out.println(Arrays.toString(cur[j]));
			System.out.println();
			System.out.println();
		}
		int total = 0;
		for (int i = 0; i < r; i++) 
			for (int j = 0; j < c; j++)
				total += cur[i][j];
		
		System.out.println(total + 2);
	}

	private static void uprotate(int[][] cur, int row, int col) {
		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { 1, 0, -1, 0 };
		int curR = row, curC = col + 1;
		int idx = 0, tmp = 0, next = 0;
		while (true) {
			int nr = curR + dr[idx], nc = curC + dc[idx];
			if (!rangeCheck(nr, nc)) {
				idx++;
				continue;
			}
			next = cur[curR][curC];
			cur[curR][curC] = tmp;
			if (cur[nr][nc] == -1)
				return;
			tmp = next;
			curR = nr;
			curC = nc;
		}
	}

	private static void downrotate(int[][] cur, int row, int col) {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int curR = row, curC = col + 1;
		int idx = 0, tmp = 0, next = 0;
		while (true) {
			int nr = curR + dr[idx], nc = curC + dc[idx];
			if (!rangeCheck(nr, nc)) {
				idx++;
				continue;
			}
			next = cur[curR][curC];
			cur[curR][curC] = tmp;
			if (cur[nr][nc] == -1)
				return;
			tmp = next;
			curR = nr;
			curC = nc;
		}
	}

	private static void spread(int[][] cur) {
		int dr[] = { 0, 0, 1, -1 };
		int dc[] = { 1, -1, 0, 0 };
		int next[][] = new int[r][c];
		for (int row = 0; row < r; row++) {
			for (int col = 0; col < c; col++) {
				if (cur[row][col] > 0) {
					int dif = cur[row][col] / 5;
					for (int idx = 0; idx < 4; idx++) {
						int nr = row + dr[idx];
						int nc = col + dc[idx];
						if (rangeCheck(nr, nc) && cur[nr][nc] != -1) {
							next[nr][nc] += dif;
							next[row][col] -= dif;
						}
					}
				}
			}
		}
		for (int row = 0; row < r; row++)
			for (int col = 0; col < c; col++)
				cur[row][col] += next[row][col];

	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}

}
