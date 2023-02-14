package part2.week03.A_221011.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_SWEA_DFS_UnitedArray {
	static int N, M, adjMatrix[][][];
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			adjMatrix = new int[N + 1][N + 1][2];

			StringTokenizer st;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b][0] = 1;
				adjMatrix[b][a][1] = 1;

			}

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				cnt = 0;
				for (int sw = 0; sw < 2; sw++)
					DFS(i, new boolean[N + 1], sw);
				if (cnt == N - 1)
					answer++;
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	static void DFS(int cur, boolean[] visited, int sw) { // start 학생부터 자신보다 키가 큰 학생 따라 탐색
		visited[cur] = true;

		for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다보기
			if (adjMatrix[cur][i][sw] == 1 && !visited[i]) {
				cnt++;
				DFS(i, visited, sw);
			}
		}
	}
}
