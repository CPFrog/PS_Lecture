package part2.week02.B_221005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_BOJ {
	static int rows, cols;
	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());

		boolean cheese[][] = new boolean[rows][cols];

		int time = 0;
		int prevCheese = 0;
		int curCheese = 0;
		for (int i = 0; i < rows; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cols; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					curCheese++;
					cheese[i][j] = true;
				}
			}
		}
		while (curCheese > 0) {
			time++;
			boolean[][] newCheese = bfs(cheese);
			prevCheese = curCheese;
			curCheese = getCnt(newCheese);
		}
		System.out.println(time + "\n" + prevCheese);
	}

	private static int getCnt(boolean[][] newCheese) {
		int cnt = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				if (newCheese[i][j])
					cnt++;
		}
		return cnt;
	}

	private static boolean[][] bfs(boolean[][] cheese) {
		boolean newCheese[][] = new boolean[rows][cols];
		boolean visited[][] = new boolean[rows][cols];

		for (int i = 0; i < rows; i++)
			Arrays.fill(newCheese[i], true);
		Queue<Pos> q = new LinkedList<>();

		q.offer(new Pos(0, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (rangeCheck(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					newCheese[nr][nc] = false;
					if (!cheese[nr][nc])
						q.offer(new Pos(nr, nc));
				}
			}
		}
		return newCheese;
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < rows && nc >= 0 && nc < cols;
	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
