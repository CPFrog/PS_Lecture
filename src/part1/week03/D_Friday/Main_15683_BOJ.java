package part1.week03.D_Friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683_BOJ {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int r, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int[][] map = new int[r][c];
		ArrayList<Camera> cams = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					cams.add(new Camera(new Point(i, j), map[i][j]));
				}
			}
		}
		int[] heads = new int[cams.size()];
		int minVal = Integer.MAX_VALUE;
		do {
			int tmp = makeField(map, cams, 0, heads);
			if (minVal > tmp)
				minVal = tmp;
		} while (nextHead(cams, heads));
		System.out.println(minVal);
	}

	private static boolean nextHead(ArrayList<Camera> cams, int[] heads) {
		for (int i = 0; i < heads.length; i++) {
			if (cams.get(i).kind == 2) {
				if (heads[i] + 1 == 2)
					heads[i] = 0;
				else {
					heads[i]++;
					return true;
				}
			} else if (cams.get(i).kind == 5)
				continue;
			else {
				if (heads[i] + 1 == 4)
					heads[i] = 0;
				else {
					heads[i]++;
					return true;
				}
			}
		}
		return false;
	}

	private static int makeField(int[][] map, ArrayList<Camera> cams, int depth, int[] heads) {
		boolean visited[][] = new boolean[r][c];
		for (int camIdx = 0; camIdx < cams.size(); camIdx++) {
			Camera cur = cams.get(camIdx);
			Point startPos = cur.pos;
			visited[startPos.r][startPos.c] = true;
			int head = heads[camIdx];
			switch (cur.kind) {
			case 1:
				int nr1 = startPos.r + dr[head];
				int nc1 = startPos.c + dc[head];
				while (rangeCheck(nr1, nc1)) {
					visited[nr1][nc1] = true;
					if (map[nr1][nc1] == 6)
						break;
					nr1 += dr[head];
					nc1 += dc[head];
				}
				break;
			case 2:
				for (int idx = 0; idx < 2; idx++) {
					int nr2 = startPos.r + dr[head + 2 * idx];
					int nc2 = startPos.c + dc[head + 2 * idx];
					while (rangeCheck(nr2, nc2)) {
						visited[nr2][nc2] = true;
						if (map[nr2][nc2] == 6)
							break;
						nr2 += dr[head + 2 * idx];
						nc2 += dc[head + 2 * idx];
					}
				}
				break;
			case 3:
				for (int idx = 0; idx < 2; idx++) {
					int nr3 = startPos.r + dr[(head + idx) % 4];
					int nc3 = startPos.c + dc[(head + idx) % 4];
					while (rangeCheck(nr3, nc3)) {
						visited[nr3][nc3] = true;
						if (map[nr3][nc3] == 6)
							break;
						nr3 += dr[(head + idx) % 4];
						nc3 += dc[(head + idx) % 4];
					}
				}
				break;
			default:
				for (int idx = 0; idx < 4; idx++) {
					if (cur.kind == 4 && idx == head)
						continue;
					int nr4 = startPos.r + dr[idx];
					int nc4 = startPos.c + dc[idx];
					while (rangeCheck(nr4, nc4)) {
						visited[nr4][nc4] = true;
						if (map[nr4][nc4] == 6)
							break;
						nr4 += dr[idx];
						nc4 += dc[idx];
					}
				}
				break;
			}
		}
		int cnt = 0;
		for (int ri=0;ri<r;ri++) {
			for (int ci=0;ci<c;ci++)
				if (!visited[ri][ci] && map[ri][ci]!=6) {
					cnt++;
				}
		}
		return cnt;
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
