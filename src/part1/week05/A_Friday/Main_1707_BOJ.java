package part1.week05.A_Friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1707_BOJ {
	static int v, e;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			ArrayList<Integer> arr[] = new ArrayList[v];
			for (int i = 0; i < v; i++)
				arr[i] = new ArrayList<>();
			int group[] = new int[v];
			while (e-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				arr[a].add(b);
				arr[b].add(a);
			}
			boolean isAvailable = true;
			for (int i = 0; i < v && isAvailable; i++) {
				if(group[i]==0)
					isAvailable = bfs(arr, group, i);
			}
			sb.append((isAvailable ? "YES" : "NO") + "\n");
		}
		System.out.print(sb.toString());
	}

	private static boolean bfs(ArrayList<Integer>[] arr, int[] group, int start) {
		Queue<Integer> q = new LinkedList<>();
		group[start] = 1;
		q.offer(start);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : arr[cur]) {
				if (group[next] == 0) {
					group[next] = group[cur] * -1;
					q.offer(next);
				} else {
					if (group[cur] == group[next])
						return false;
				}
			}
		}
		return true;
	}
}
