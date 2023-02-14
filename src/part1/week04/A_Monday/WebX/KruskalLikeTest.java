package part1.week04.A_Monday.WebX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class KruskalLikeTest {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int edgeN = Integer.parseInt(st.nextToken());
		Edge edges[] = new Edge[edgeN];
		ArrayList<Integer> adjList[] = new ArrayList[n];
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeN; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			int minNum = from > to ? to : from;
			int maxNum = from > to ? from : to;
			
			edges[i] = new Edge(minNum, maxNum, cost);
		}
		Arrays.sort(edges);

		int totalCost = 0;
		for (Edge e : edges) {
			if (parent[e.to] != parent[e.from]) {
				int prevParent=parent[e.to];
				parent[e.to] = parent[e.from];
				totalCost += e.cost;
				for (int i =0;i<n;i++)
					if(parent[i]==prevParent)
						parent[i]=parent[e.from];
			}
		}
		System.out.println(totalCost);

	}

	static class Node {
		int num, nextNode;

		public Node(int num, int nextNode) {
			this.num = num;
			this.nextNode = nextNode;
		}

	}

	static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost == o.cost ? this.from - o.from : this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "[" + from + ", " + to + "] cost=" + cost+ " ";
		}

	}

}
