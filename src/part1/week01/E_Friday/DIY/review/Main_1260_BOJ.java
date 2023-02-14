package part1.week01.E_Friday.DIY.review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_BOJ {
	static List<Integer>[] map;
	static BufferedWriter bw;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		map = new ArrayList[n + 1];
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= n; i++)
			map[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start].add(end);
			map[end].add(start);
		}
		for (int i = 1; i <= n; i++)
			Collections.sort(map[i]);
		dfs(v);
		Arrays.fill(visited, false);
		bw.append("\n");
		bfs(v);
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int v) throws Exception {
		visited[v] = true;
		bw.append(v + " ");
		for (int i : map[v])
			if (!visited[i])
				dfs(i);
	}

	private static void bfs(int start) throws Exception {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			bw.append(cur + " ");
			for (int i : map[cur]) {
				if (!visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}

	}

}
