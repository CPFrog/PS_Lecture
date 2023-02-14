package part1.week04.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer> adjList[] = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();

		boolean[] visited = new boolean[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		boolean hasChain = false;
		for (int i = 0; i < n && !hasChain; i++) {
			visited[i] = true;
			hasChain = dfs(adjList, i, visited, 1);
			visited[i] = false;
		}

		System.out.println(hasChain ? 1 : 0);
	}

	private static boolean dfs(ArrayList<Integer>[] adjList, int start, boolean[] visited, int depth) {
		if (depth == 5)
			return true;
		boolean hasFound = false;
		for (int i = 0; i < adjList[start].size() && !hasFound; i++) {
			int next = adjList[start].get(i);
			if (!visited[next]) {
				visited[next] = true;
				hasFound = dfs(adjList, next, visited, depth + 1);
				visited[next] = false;
			}
		}
		return hasFound;
	}
}
