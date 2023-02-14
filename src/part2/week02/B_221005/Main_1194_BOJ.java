package part2.week02.B_221005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_BOJ {
	static int rows, cols;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());

		char[][] maze = new char[rows][cols];
		int startR = 0, startC = 0;
		for (int i = 0; i < rows; i++) {
			maze[i] = br.readLine().toCharArray();
			for (int j = 0; j < cols; j++) {
				if (maze[i][j] == '0') {
					startR = i;
					startC = j;
					maze[i][j] = '.';
				}
			}
		}
		int[][][] cost = new int[rows][cols][1 << 7];
		go(maze, cost, startR, startC);
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	private static void go(char[][] maze, int[][][] cost, int startR, int startC) {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(startR, startC, 0));
		cost[startR][startC][0] = 1;
		while (!q.isEmpty()) {
			Info cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (rangeCheck(nr, nc) && maze[nr][nc] != '#' && cost[nr][nc][cur.flag] == 0) {
					cost[nr][nc][cur.flag] = cost[cur.r][cur.c][cur.flag] + 1;
					char c = maze[nr][nc];
					if (c >= 'A' && c <= 'F') {
						if (((cur.flag) & (1 << (c - 'A'))) > 0)
							q.offer(new Info(nr, nc, cur.flag));
					} else if (c >= 'a' && c <= 'f') {
						int newFlag = (cur.flag) | (1 << (c - 'a'));
						cost[nr][nc][newFlag] = cost[nr][nc][cur.flag];
						q.offer(new Info(nr, nc, newFlag));
					} else if (c == '1') {
						System.out.println(cost[nr][nc][cur.flag]-1);
						return;
					} else if (c == '.') {
						q.offer(new Info(nr, nc, cur.flag));
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < rows && nc >= 0 && nc < cols;
	}

	private static class Info {
		int r, c, flag;

		public Info(int r, int c, int flag) {
			this.r = r;
			this.c = c;
			this.flag = flag;
		}
	}
}
