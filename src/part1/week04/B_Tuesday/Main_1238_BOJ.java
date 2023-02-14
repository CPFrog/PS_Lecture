package part1.week04.B_Tuesday;

import java.io.*;
import java.util.*;

public class Main_1238_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken())-1;

		int[][] totalCost = new int[n][n];
		ArrayList<Edge>[] adjList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(totalCost[i], Integer.MAX_VALUE);
			adjList[i] = new ArrayList<>();
			totalCost[i][i]=0;
		}

		PriorityQueue<Edge> q = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());

			Edge tmp = new Edge(from, to, cost);
			adjList[from].add(tmp);
			totalCost[from][to] = cost;
			q.offer(tmp);
		}

		while (!q.isEmpty()) {
			Edge cur = q.poll();
			for (Edge e : adjList[cur.to]) {
				if (totalCost[cur.from][cur.to] + e.cost < totalCost[cur.from][e.to]) {
					totalCost[cur.from][e.to] = totalCost[cur.from][cur.to] + e.cost;
					q.offer(new Edge(cur.from, e.to, totalCost[cur.from][e.to]));
				}
			}
		}
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			if (i != x && maxValue < totalCost[i][x] + totalCost[x][i])
				maxValue = totalCost[i][x] + totalCost[x][i];

		System.out.println(maxValue);
	}

	static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int current, int next, int cost) {
			this.from = current;
			this.to = next;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost != o.cost ? this.cost - o.cost : this.to - o.to;
		}
	}
}
