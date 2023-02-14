package part2.week03.A_221011.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_SWEA_BFS {
	static int N, M, adjMatrix[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			adjMatrix = new int[N + 1][N + 1];

			StringTokenizer st;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
			}

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				if (greaterBFS(i) + lesserBFS(i) == N - 1)
					answer++;
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	static int greaterBFS(int start) { // start 학생부터 자신보다 키가 큰 학생 따라 탐색
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다보기
				if (adjMatrix[cur][i] == 1 && !visited[i]) {
					cnt++;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		return cnt;
	}

	static int lesserBFS(int start) { // start 학생부터 자신보다 키가 작은 학생 따라 탐색
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다보기
				if (adjMatrix[i][cur] == 1 && !visited[i]) {
					cnt++;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		return cnt;
	}

}
