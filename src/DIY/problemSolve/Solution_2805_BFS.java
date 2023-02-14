package DIY.problemSolve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_2805_BFS {
	static boolean[][] isVisited;
	static int[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static long sum;
	static int n;

	static class Pos {
		int x, y;
		int count;

		Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			count = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sum = 0;
			n = Integer.parseInt(br.readLine());
			isVisited = new boolean[n][n];
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++)
					map[i][j] = line.charAt(j) - '0';
			}
			isVisited[n / 2][n / 2] = true;
			visit(n / 2, n / 2);

			System.out.println("#" + t + " " + sum);
		}
	}

	static void visit(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		Pos start = new Pos(x, y, 0);
		q.offer(start);
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			sum += map[cur.x][cur.y];
			if (cur.count + 1 <= n / 2) {
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && !isVisited[nx][ny]) {
						isVisited[nx][ny] = true;
						Pos tmp = new Pos(nx, ny, cur.count + 1);
						q.offer(tmp);
					}

				}
			}
		}
	}
}
