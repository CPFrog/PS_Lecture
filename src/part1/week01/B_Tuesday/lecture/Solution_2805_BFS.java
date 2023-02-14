package part1.week01.B_Tuesday.lecture;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2805_BFS {
	static int[][] map;
	static int n;
	static boolean[][] visited;
	static long sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				char[] carr = s.toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = carr[j] - '0';
				}
			}

			sum = 0;
			bfs();
			System.out.println("#" + t + " " + sum);
			
//			for(int i=0;i<n;i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { n / 2, n / 2 });
//		sum += map[n / 2][n / 2];
		visited[n / 2][n / 2] = true;
		for (int i = 0; i < n; i++) { // 자신 제외하고 n/2겹
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!visited[nr][nc]) {
					q.offer(new int[] { nr, nc });
					sum += map[nr][nc];
					visited[nr][nc] = true;
				}
			}
		}
	}
}
