package part2.week02.A_221004.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_SWEA {
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int width, height;
	static int curMax;
	static boolean[][] breakTarget;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			int[][] graph = new int[height][width];
			int[] top = new int[width];
			Arrays.fill(top, height);

			int lefts = 0;
			for (int i = 0; i < height; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < width; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if (graph[i][j] != 0) {
						lefts++;
						if (top[j] == 0)
							top[j] = i;
					}
				}
			}
			for (int k = 0; k < n; k++) {
				curMax = 0;
				for (int i = 0; i < width; i++)
					tryBreak(graph, i, top[i]);

				doBreak(graph, top);
				lefts -= curMax;
			}

			sb.append("#" + t + " " + lefts + "\n");
		}
		System.out.println(sb.toString());
	}

	// 포기. ㅅㅂ 구슬 밑으로 내리는 구현이 제일 머리아파..
	private static void doBreak(int[][] graph, int[] top) {
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				if(breakTarget[i][j])
					graph[i][j]=0;
			}
		}
		for(int j=0;j<width;j++) {
			for(int i=height-1;i>=0;i--) {
				if(graph[i][j]==0) {
					if(i==0) continue;
					graph[i][j]=graph[i-1][j];
					
				}
			}
		}
	}

	private static void tryBreak(int[][] graph, int startC, int startR) {
		Queue<Pos> q = new LinkedList<>();
		boolean visited[][] = new boolean[width][height];
		q.offer(new Pos(startR, startC));
		visited[startR][startC] = true;

		int cnt = 1;
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i < 4; i++) {
				for (int d = 1; d <= graph[cur.r][cur.c] - 1; d++) {
					int nr = cur.r + dr[i] * d;
					int nc = cur.r + dc[i] * d;
					if (rangeCheck(nr, nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						if (graph[nr][nc] != 0) {
							q.offer(new Pos(nr, nc));
							cnt++;
						}
					}
				}
			}
		}
		if (cnt > curMax) {
			curMax = cnt;
			breakTarget = visited;
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < height && nc >= 0 && nc < width;
	}

	private static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
