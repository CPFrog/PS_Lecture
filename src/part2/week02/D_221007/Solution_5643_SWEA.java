package part2.week02.D_221007;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_5643_SWEA {
	private static final int INF = Integer.MAX_VALUE / 100;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/part2/week02/D_221007/SampleTC/SWEA_5643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int[][] cost = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(cost[i], INF);
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1; // 작은 애
				int e = Integer.parseInt(st.nextToken()) - 1; // 큰 애
				cost[s][e] = 1;
			}

			for (int mid = 0; mid < n; mid++) {
				for (int start = 0; start < n; start++) {
					if (start == mid)
						continue;
					for (int end = 0; end < n; end++) {
						if (start == end || end == mid)
							continue;
						if (cost[start][end] > cost[start][mid] + cost[mid][end])
							cost[start][end] = cost[start][mid] + cost[mid][end];
					}
				}
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				int tmp = 0;
				for (int j = 0; j < n; j++) {
					if (cost[i][j] != INF || cost[j][i] != INF)
						tmp++;
				}
				if (tmp == n - 1)
					ans++;
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.print(sb.toString());
	}
}
