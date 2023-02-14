package part1.week04.B_Tuesday;

import java.io.*;
import java.util.*;

public class Solution_3124_SWEA {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			int parent[] = new int[v];
			for(int i=0;i<v;i++)
				parent[i]=i;
			PriorityQueue<Edge> q = new PriorityQueue<>();
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
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
			sb.append("#" + t + " " + total + "\n");
		}
		System.out.println(sb.toString());
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
