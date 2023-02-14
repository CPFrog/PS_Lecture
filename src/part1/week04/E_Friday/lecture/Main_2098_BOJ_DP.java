package part1.week04.E_Friday.lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098_BOJ_DP {
	static int[][] dist, map;
	static int n;
	static final int INF = Integer.MAX_VALUE / 100;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = i;
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int minCircular = INF;
		dist = new int[1 << n][n];
		for (int i = 0; i < 1 << n; i++)
			Arrays.fill(dist[i], -1);
		minCircular = tsp(1, 0);
		System.out.println(minCircular);
	}

	private static int tsp(int visited, int city) {
		if (visited == (1 << n) - 1) {
			if (map[city][0] == 0)
				return INF;
			return dist[city][0];
		}
		if (dist[visited][city] != -1)
			return dist[visited][city];
		dist[visited][city] = INF;
		for (int i = 0; i < n; i++) {
			if ((visited & (i << i)) == 0 && map[city][i] != 0) {
				int result = tsp((visited | (1 << i)), i) + dist[city][i];
				dist[visited][city] = Math.min(result, dist[visited][city]);
			}
		}
		return dist[visited][city];
	}

}
