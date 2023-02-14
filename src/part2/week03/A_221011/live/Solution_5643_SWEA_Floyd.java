package part2.week03.A_221011.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_SWEA_Floyd {
	static int N, M, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			int[][] adjMatrix = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				adjMatrix[i][0] = -1; // 탐색하지 않은 상태의 초기값. 0열을 visited의 대용으로 쓸것!
			}

			StringTokenizer st;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;

			}

			int answer = 0;
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					if (i == k)
						continue;
					for (int j = 1; j <= N; j++) {
						if (adjMatrix[i][j] == 1)
							continue;
						adjMatrix[i][j] = adjMatrix[i][k] & adjMatrix[k][j];
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adjMatrix[i][0] += adjMatrix[i][j];
					adjMatrix[0][j] += adjMatrix[i][j];
				}
			}
			for (int k = 1; k <= N; k++)
				if (adjMatrix[k][0] + adjMatrix[0][k] == N - 1)
					answer++;
			System.out.println("#" + t + " " + answer);
		}
	}

	static void dfs(int cur, int[][] adjMatrix) { // start 학생부터 자신보다 키가 큰 학생 따라 탐색
		for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다보기
			if (adjMatrix[cur][i] == 1) {
				if (adjMatrix[i][0] == -1)
					dfs(i, adjMatrix);
				if (adjMatrix[i][0] > 0) { // i보다 큰 정점이 존재 : cur<i<j를 만족하는 j 존재 -> cur<j 상태로 메모
					for (int j = 1; j <= N; j++)
						if (adjMatrix[i][j] == 1)
							adjMatrix[cur][j] = 1;

				}
			}
		}
		int cnt = 0;
		for (int k = 1; k <= N; k++)
			cnt += adjMatrix[cur][k];

		adjMatrix[cur][0] = cnt;
	}
}
