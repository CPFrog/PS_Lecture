package part2.week02.C_221006.DIY;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_BOJ {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/part2/week02/C_221006/SampleTC/BOJ_9205.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Pos start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Pos[] cs = new Pos[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				cs[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			Pos end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Queue<Pos> q = new LinkedList<>();
			q.offer(start);
			boolean visited[] = new boolean[n];
			boolean hasArrived = false;
			while (!q.isEmpty()) {
				Pos cur = q.poll();
				if (getDistance(cur, end) <= 1000) {
					hasArrived = true;
					break;
				}
				for (int i = 0; i < n; i++) {
					if (!visited[i] && getDistance(cur, cs[i]) <= 1000) {
						visited[i] = true;
						q.offer(cs[i]);
					}
				}
			}
			sb.append((hasArrived ? "happy" : "sad") + "\n");
		}
		System.out.print(sb.toString());
	}

	private static int getDistance(Pos cur, Pos pos) {
		return Math.abs(cur.x - pos.x) + Math.abs(cur.y - pos.y);
	}

	private static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
