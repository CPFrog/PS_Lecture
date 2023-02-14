package part1.week03.D_Friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683_BOJ_DFS {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int r, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int[][] map = new int[r][c];
		ArrayList<Camera> cams = new ArrayList<>();
		boolean[][] visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5)
					cams.add(new Camera(new Point(i, j), map[i][j]));
				else if (map[i][j] == 6)
					visited[i][j] = true;
			}
		}
		System.out.println(makeField(map, cams, 0, visited));
	}

	private static int makeField(int[][] map, ArrayList<Camera> cams, int depth, boolean[][] visited) {
		if (depth == cams.size()) {
			int cnt = 0;
			for (int ri = 0; ri < r; ri++) {
				for (int ci = 0; ci < c; ci++)
					if (!visited[ri][ci])
						cnt++;

			}
			return cnt;
		}
		int minVal = Integer.MAX_VALUE;
		Camera cur = cams.get(depth);
		for (int i = 0; i < 4; i++) {
			boolean[][] visitedCopy = arrCopy(visited);
			Point startPos = cur.pos;
			visitedCopy[startPos.r][startPos.c] = true;
			switch (cur.kind) {
				case 1:
					int nr1 = startPos.r + dr[i];
					int nc1 = startPos.c + dc[i];
					while (rangeCheck(nr1, nc1) && map[nr1][nc1] != 6) {
						visitedCopy[nr1][nc1] = true;
						nr1 += dr[i];
						nc1 += dc[i];
					}
					break;
				case 2:
					for (int idx = 0; idx < 2; idx++) {
						int nr2 = startPos.r + dr[i + 2 * idx];
						int nc2 = startPos.c + dc[i + 2 * idx];
						while (rangeCheck(nr2, nc2) && map[nr2][nc2] != 6) {
							visitedCopy[nr2][nc2] = true;
							nr2 += dr[i + 2 * idx];
							nc2 += dc[i + 2 * idx];
						}
					}
					break;
				case 3:
					for (int idx = 0; idx < 2; idx++) {
						int nr3 = startPos.r + dr[(i + idx) % 4];
						int nc3 = startPos.c + dc[(i + idx) % 4];
						while (rangeCheck(nr3, nc3) && map[nr3][nc3] != 6) {
							visitedCopy[nr3][nc3] = true;
							nr3 += dr[(i + idx) % 4];
							nc3 += dc[(i + idx) % 4];
						}
					}
					break;
				default:
					for (int idx = 0; idx < 4; idx++) {
						if (cur.kind == 4 && idx == i)
							continue;
						int nr4 = startPos.r + dr[idx];
						int nc4 = startPos.c + dc[idx];
						while (rangeCheck(nr4, nc4) && map[nr4][nc4] != 6) {
							visitedCopy[nr4][nc4] = true;
							nr4 += dr[idx];
							nc4 += dc[idx];
						}
					}
					break;
			}
			int tmp = makeField(map, cams, depth + 1, visitedCopy);
			if (minVal > tmp)
				minVal = tmp;
			if (cams.get(depth).kind == 2 && i == 1) break;
			else if (cams.get(depth).kind == 5 && i == 0) break;
		}
		return minVal;
	}

	static boolean[][] arrCopy(boolean[][] b) {
		boolean[][] tmp = new boolean[b.length][b[0].length];
		for (int i = 0; i < tmp.length; i++)
			System.arraycopy(b[i], 0, tmp[i], 0, b[i].length);
		return tmp;
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}

	static class Camera {
		Point pos;
		int kind;

		public Camera(Point pos, int kind) {
			this.pos = pos;
			this.kind = kind;
		}
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}