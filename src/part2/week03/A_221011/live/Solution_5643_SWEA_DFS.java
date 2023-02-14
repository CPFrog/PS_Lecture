package part2.week03.A_221011.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_SWEA_DFS {
	static int N, M, adjMatrix[][];
	static int biggerCnt, smallerCnt;

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
				biggerCnt = smallerCnt = 0;
				greaterDFS(i, new boolean[N + 1]);
				lesserDFS(i, new boolean[N + 1]);
				if (biggerCnt + smallerCnt == N - 1)
					answer++;
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	static void greaterDFS(int cur, boolean[] visited) { // start 학생부터 자신보다 키가 큰 학생 따라 탐색
		visited[cur] = true;

		for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다보기
			if (adjMatrix[cur][i] == 1 && !visited[i]) {
				biggerCnt++;
				greaterDFS(i, visited);
			}
		}
	}
	static void lesserDFS(int cur, boolean[] visited) { // start 학생부터 자신보다 키가 큰 학생 따라 탐색
		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다보기
			if (adjMatrix[i][cur] == 1 && !visited[i]) {
				smallerCnt++;
				lesserDFS(i, visited);
			}
		}
	}

	

}
