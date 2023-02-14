package part1.week03.C_Thursday.live;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
	static int[][] adjMatrix;
	static int n;
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		int e = sc.nextInt();
		adjMatrix = new int[n][n]; // 0으로 자동 초기화
		for (int i = 0; i < e; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		bfs();
		visited = new boolean[n];
		dfs(0);
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n];

		visited[0] = true;
		q.offer(0);

		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print((char) cur + 'A');
			for (int i = 0; i < n; i++) {
				if (adjMatrix[cur][i] != 0 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}

			}
		}
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.print((char) cur + 'A');
		for (int i = 0; i < n; i++) {
			if (adjMatrix[cur][i] != 0 && !visited[i])
				dfs(i);
		}
	}

}
