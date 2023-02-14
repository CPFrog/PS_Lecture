package part2.week03.A_221011.webX;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_SWEA {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/part2/week03/A_221011/SampleTC/SWEA_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			// 입력부분
			int n = Integer.parseInt(br.readLine());
			int[][] island = new int[n][2]; // 섬의 좌표
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					island[j][i] = Integer.parseInt(st.nextToken());
			}
			double tax = Double.parseDouble(br.readLine());

			boolean visited[] = new boolean[n];

			PriorityQueue<Road> q = new PriorityQueue<>();
			q.offer(new Road(0, 0, 0L));
			double totalValue = 0;
			int cnt = 0;
			while (!q.isEmpty() && cnt < n) {
				Road cur = q.poll();
				if (visited[cur.to])
					continue;
				cnt++;
				visited[cur.to] = true;
				totalValue += cur.cost * tax;
				for (int i = 1; i < n; i++) {
					if (!visited[i])
						q.offer(new Road(cur.to, i, getSquaredDistance(island[cur.to], island[i])));
				}
			}
			sb.append("#" + t + " " + String.format("%.0f", totalValue) + "\n");
		}
		System.out.print(sb.toString());
	}

	public static long getSquaredDistance(int[] from, int[] to) {
		long difX = from[0] - to[0];
		long difY = from[1] - to[1];
		return difX * difX + difY * difY;
	}

	static class Road implements Comparable<Road> {
		int from, to;
		Long cost;

		public Road(int from, int to, Long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Road o) {
			return this.cost != o.cost ? this.cost.compareTo(o.cost) : this.from - o.from;
		}
	}
}
