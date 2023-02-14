package part2.week02.A_221004.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_1249_SWEA {
	static int n;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];

			for (int i = 0; i < n; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < n; j++)
					graph[i][j] = line[j] - '0';
			}
			
			sb.append("#"+t+" "+dijkstra(0, 0)+"\n");
		}
		System.out.println(sb.toString());
	}

	private static int dijkstra(int startR, int startC) {
		int[][] cost = new int[n][n];
		for(int i=0;i<n;i++)
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(startR, startC, 0));
		cost[startR][startC] = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(rangeCheck(nr,nc) && cost[nr][nc]>cur.cost+graph[nr][nc]) {
					 cost[nr][nc]=cur.cost+graph[nr][nc];
					 if(nr==n-1&&nc==n-1)
						 return cost[nr][nc];
					 q.offer(new Node(nr, nc, cost[nr][nc]));
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}

	private static class Node implements Comparable<Node> {
		int r, c, cost;

		Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost != o.cost ? this.cost - o.cost : (this.r != o.r ? this.r - o.r : this.c - o.c);
		}
	}
}
