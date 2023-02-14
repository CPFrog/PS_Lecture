package part2.week02.D_221007;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1868_SWEA {
	static int curMin, n, blanks;
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/part2/week02/C_221007/SampleTC/SWEA_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			curMin = 0;
			n = Integer.parseInt(br.readLine());
			char[][] board = new char[n][n];
			blanks = 0;
			for (int i = 0; i < n; i++) {
				board[i] = br.readLine().toCharArray();
				for (int j = 0; j < n; j++)
					if (board[i][j] != '*')
						blanks++;
			}
			int clicks = 0;
			boolean visited[][] = new boolean[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (!visited[r][c] && board[r][c] == '.' && getMine(board, r, c) == 0) {
						bfs(board, visited, r, c);
						clicks++;
					}
				}
			}
			clicks+=blanks;
			sb.append("#" + t + " " + clicks + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int getMine(char[][] board, int r, int c) {
		int mines = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (rangeCheck(nr, nc) && board[nr][nc] == '*')
				mines++;
		}
		return mines;
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}

	private static void bfs(char[][] board, boolean[][] visited, int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		board[r][c] = '0';
		q.offer(new Pos(r, c));
		blanks--;
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i < 8; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (rangeCheck(nr, nc) && !visited[nr][nc] && board[nr][nc] == '.') {
					board[nr][nc] = (char) (getMine(board, nr, nc) + '0');
					blanks--;
					visited[nr][nc]=true;
					if (board[nr][nc] == '0') {
						q.offer(new Pos(nr,nc));
					}
				}
			}
		}
	}

	private static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
