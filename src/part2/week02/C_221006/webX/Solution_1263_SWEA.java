package part2.week02.C_221006.webX;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_SWEA {
	private static final int INF = 1000 * 1000;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/part2/week02/C_221006/SampleTC/SWEA_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] cost = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cost[i][j] = Integer.parseInt(st.nextToken());
					if (cost[i][j] == 0 && i != j)
						cost[i][j] = INF;
				}
			}

			for (int mid = 0; mid < n; mid++) {
				for (int s = 0; s < n; s++) {
					if (mid == s)
						continue;
					for (int e = 0; e < n; e++) {
						if (mid == e || s == e)
							continue;
						if (cost[s][e] > cost[s][mid] + cost[mid][e]) {
							cost[s][e] = cost[s][mid] + cost[mid][e];
							cost[e][s] = cost[s][e];
						}
					}
				}
			}
			int minSum = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int curSum = 0;
				for (int j = 0; j < n; j++) {
					curSum += cost[i][j];
				}

				if (minSum > curSum)
					minSum = curSum;

			}
			sb.append("#" + t + " " + minSum + "\n");
		}
		System.out.print(sb.toString());
	}
}
