package part1.week01.C_Wednesday.lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_SWEA {
	static char[][] map;
	static int curR, curC;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int r, c, dir;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new char[r][c];
			curR = 0;
			curC = 0;
			for (int i = 0; i < r; i++) {
				String s = br.readLine();
				map[i] = s.toCharArray();
				// U=0, D=1, L=2, R=3
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '<') {
						curR = i;
						curC = j;
						map[i][j] = '.';
						dir = 2;
					} else if (map[i][j] == '>') {
						curR = i;
						curC = j;
						map[i][j] = '.';
						dir = 3;
					} else if (map[i][j] == '^') {
						curR = i;
						curC = j;
						map[i][j] = '.';
						dir = 0;
					} else if (map[i][j] == 'v') {
						curR = i;
						curC = j;
						map[i][j] = '.';
						dir = 1;
					}
				}
			}
			int cmdN = Integer.parseInt(br.readLine());
			char[] cmd = br.readLine().toCharArray();
			for (int i = 0; i < cmdN; i++) {
				if (cmd[i] == 'S') {
					int nr = curR + dr[dir];
					int nc = curC + dc[dir];
					while (rangecheck(nr, nc)) {
						if (map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						} else if (map[nr][nc] == '#')
							break;
						nr += dr[dir];
						nc += dc[dir];
					}
				} else {
					move(cmd[i]);
				}
			}
			switch (dir) {
			case 0:
				map[curR][curC] = '^';
				break;
			case 1:
				map[curR][curC] = 'v';
				break;
			case 2:
				map[curR][curC] = '<';
				break;
			case 3:
				map[curR][curC] = '>';
				break;
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
		}
	}

	private static void move(char c) {
		switch (c) {
		case 'U':
			dir = 0;
			break;
		case 'D':
			dir = 1;
			break;
		case 'L':
			dir = 2;
			break;
		case 'R':
			dir = 3;
			break;
		}
		int nr = curR + dr[dir];
		int nc = curC + dc[dir];
		if (rangecheck(nr, nc)) {
			if (map[nr][nc] == '.') {
				curR = nr;
				curC = nc;
			}
		}
	}

	private static boolean rangecheck(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}
}
