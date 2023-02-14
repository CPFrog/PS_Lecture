package part1.week04.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		int parent[] = new int[v];
		for (int i = 0; i < v; i++)
			parent[i] = i;
		PriorityQueue<Edge> q = new PriorityQueue<>();
		for (int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			q.offer(new Edge(a, b, cost));
		}

		long total = 0;
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			int smallP = getParent(parent, cur.small);
			int bigP = getParent(parent, cur.big);
			if (smallP != bigP) {
				parent[bigP] = smallP;
				total += cur.cost;
			}
		}
		System.out.println(total);
	}

	static int getParent(int[] parent, int a) {
		if (parent[a] != a)
			parent[a] = getParent(parent, parent[a]);
		return parent[a];
	}

	static class Edge implements Comparable<Edge> {
		int big, small, cost;

		public Edge(int big, int small, int cost) {
			this.big = big > small ? big : small;
			this.small = small < big ? small : big;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost != o.cost ? this.cost - o.cost : this.small - o.small;
		}
	}
}
