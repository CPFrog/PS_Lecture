package part1.week01.C_Wednesday.lecture;

import java.io.*;
import java.util.*;

public class Main_1260_BOJ {
	static ArrayList<Integer>[] map;
	static BufferedWriter bw;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		map = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			map[i] = new ArrayList<Integer>();
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start].add(end);
			map[end].add(start);
		}
		for (int i = 1; i <= n; i++)
			Collections.sort(map[i]);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		visited[v] = true;
		dfs(v);
		bw.append("\n");
		bw.flush();
		Arrays.fill(visited, false);
		visited[v] = true;
		bfs(v);
		bw.append("\n");
		bw.flush();
	}

	private static void bfs(int v) throws Exception {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		while (!q.isEmpty()) {
			int cur = q.poll();
			bw.append(cur + " ");
			for (int i : map[cur]) {
				if (!visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}

	private static void dfs(int v) throws Exception {
		bw.append(v + " ");
		for (int i : map[v]) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
}
