package part2.week02.A_221004.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import com.sun.corba.se.impl.orbutil.graph.Graph;

public class Solution_5656_SWEA_DFS {
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int width, height, n;
	static int minBlock;
	static boolean[][] breakTarget;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			minBlock = Integer.MAX_VALUE;
			int[][] graph = new int[height][width];

			for (int i = 0; i < height; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < width; j++)
					graph[i][j] = Integer.parseInt(st.nextToken());
			}

			go(graph, 0);

			sb.append("#" + t + " " + minBlock + "\n");
		}
		System.out.println(sb.toString());
	}

	// 구슬 던지기 게임
	static boolean go(int[][] graph, int cnt) {
		int result = getRemains(graph);
		if(result==0) {
			minBlock=result;
			return true;
		}
		if (cnt == n) { // 구슬을 다 던진 상태
			if (minBlock > result)
				minBlock = result;
			return false;

		}
		int[][] newGraph = new int[height][width];
		// 구슬 던지기 (중복 순열)
		for (int c = 0; c < width; c++) {
			int r = 0;
			while (r < height && graph[r][c] == 0)
				r++;
			if (r == height) { // 피격되는 시작 벽돌이 없는 경우
				continue; // 맞는 벽돌이 없으므로 그냥 던진 횟수만 1 증가시켜주고 게임 판 그대로 반환
			} else { // 피격되는 시작 벽돌이 있는 경우
				copy(graph, newGraph);
				// 제거될 벽돌 연쇄 처리
				boom(newGraph, r, c);
				// 피격되어 사라진 벽돌 공간에 대한 중력 처리
				down(newGraph);
				// 다음 구슬 던지기
				if(go(newGraph, cnt + 1)) return true;
			}

		}
		return false;
	}

	private static int getRemains(int[][] graph) {
		int result = 0;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++)
				if (graph[r][c] > 0)
					result++;
		}
		return result;
	}

	// 1.배열의 맨 밑 행에서부터 위로 올라가면서 탐색하는 방법
	/*
	 * private static void down(int[][] graph) { for (int c = 0; c < width; c++) {
	 * int r = height - 1; while (r > 0) { if (graph[r][c] == 0) { int nr = r - 1;
	 * while (nr > 0 && graph[nr][c] == 0) nr--;
	 * 
	 * graph[r][c] = graph[nr][c]; graph[nr][c] = 0; } r--; } } }
	 */

	// 2. 자료구조를 이용해 손쉽게 올리는 방법 (큐를 이용해 열 전체를 0으로 채워버린 뒤 맨 밑에서부터 하나씩 채워가는 로직!)
	static Stack<Integer> s = new Stack<>();

	private static void down(int[][] graph) {
		for (int c = 0; c < width; c++) {
			for (int r = 0; r < height; r++) {
				if (graph[r][c] > 0) {
					s.push(graph[r][c]);
					graph[r][c] = 0;
				}
			}
			int nr = height - 1;
			while (!s.isEmpty())
				graph[nr--][c] = s.pop();
		}
	}

	private static void boom(int[][] graph, int r, int c) {
		Queue<Pos> q = new ArrayDeque<>();
		// 벽돌이 있던 자리를 0으로 변경 -->빈칸으로 만들어서 방문처리 체크까지 할 수 있도록.

		if (graph[r][c] > 1) {
			q.offer(new Pos(r, c, graph[r][c]));
		}
		graph[r][c] = 0;

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			// 벽돌의 크기 -1 만큼 주변 벽돌(4방향) 연쇄 처리
			for (int d = 0; d < 4; d++) {
				int nr = cur.r;
				int nc = cur.c;
				for (int k = 1; k < cur.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if (rangeCheck(nr, nc) && graph[nr][nc] > 0) {
						if (graph[nr][nc] > 1)
							q.offer(new Pos(nr, nc, graph[nr][nc]));
						graph[nr][nc] = 0;
					} 
				}

			}

		}

	}

	private static void copy(int[][] graph, int[][] newGraph) {
		for (int r = 0; r < height; r++)
			for (int c = 0; c < width; c++)
				newGraph[r][c] = graph[r][c];
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < height && nc >= 0 && nc < width;
	}

	private static class Pos {
		int r, c, cnt;

		public Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt; // 원본 벽돌의 크기
		}
	}
}
