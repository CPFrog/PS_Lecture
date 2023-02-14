package part1.week02.E_Friday;

import java.io.*;
import java.util.*;

public class Main_2606_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer> nodes[] = new ArrayList[n + 1];
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++)
			nodes[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			nodes[from].add(to);
			nodes[to].add(from);
		}
		q.offer(1);
		visited[1] = true;
		int infected = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i : nodes[cur]) {
				if (!visited[i]) {
					infected++;
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		System.out.println(infected);
	}

}
