package part1.week04.D_Thursday.WebX;

import java.io.*;
import java.util.*;

public class Main_1197_Prim {
	static int v, e;
	static List<Edge>[] adj;
	static PriorityQueue<Edge> points;

	static class Edge implements Comparable<Edge> {
		int v, weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight != o.weight ? this.weight - o.weight : this.v - o.v;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		adj = new ArrayList[v + 1];

		for (int i = 0; i < v + 1; i++)
			adj[i] = new ArrayList<>();

		points = new PriorityQueue<>();
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(e, w));
			adj[e].add(new Edge(s, w));
		}
		System.out.println(prim());
	}

	private static long prim() {
		int min = 0;
		boolean[] visited = new boolean[v + 1];
		PriorityQueue<Edge> points = new PriorityQueue<>();
		points.offer(new Edge(1, 0));
		int cnt = 0;
		while (!points.isEmpty()) {
			Edge e = points.poll();
			if (!visited[e.v]) {
				min += e.weight;
				visited[e.v] = true;
				if (++cnt == v)
					break;
				for (Edge next:adj[e.v]) 
					if(!visited[next.v])
						points.offer(next);
			}
		}
		return min;
	}

}
