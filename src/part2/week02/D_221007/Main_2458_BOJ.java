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

public class Main_2458_BOJ {
	private static final int INF = Integer.MAX_VALUE / 100;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] cost = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(cost[i], INF);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
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
		System.out.print(ans);
	}
}
