package part1.week01.E_Friday.lecture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_BOJ {
	static int n, m, v;
	static int[][] map;
	static int[] dfs, bfs;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		map = new int[n][n];
		dfs = new int[n + 1];
		bfs = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map[s - 1][e - 1] = 1;
			map[e - 1][s - 1] = 1;
		}
		dfs(v - 1);
		bw.append("\n" + v + " ");
		bfs(v - 1);
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int s) throws Exception {
		Queue<Integer> q = new LinkedList<>();
		bfs[s] = 1;
		q.offer(s);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < n; i++) {
				if (map[cur][i] == 1 && bfs[i] == 0) {
					bfs[i] = 1;
					q.offer(i);
					bw.append((i + 1) + " ");
				}
			}

		}

	}

	private static void dfs(int s) throws Exception {
		dfs[s] = 1;
		bw.append((s + 1) + " ");
		for (int e = 0; e < n; e++)
			if (map[s][e] == 1 && dfs[e] == 0)
				dfs(e);
	}

}
