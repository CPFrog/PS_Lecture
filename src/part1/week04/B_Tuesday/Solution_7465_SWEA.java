package part1.week04.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7465_SWEA {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] parent = new int[n];
			for (int i = 0; i < n; i++)
				parent[i] = i;

			int groups = n;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				if (union(parent, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1))
					groups--;
			}
			sb.append("#"+t+" "+groups+"\n");
		}
		System.out.print(sb.toString());
	}

	static int getParent(int[] parent, int a) {
		if (parent[a] != a)
			parent[a] = getParent(parent, parent[a]);
		return parent[a];
	}

	static boolean union(int[] parent, int a, int b) {
		int big = getParent(parent, a > b ? a : b);
		int small = getParent(parent, a < b ? a : b);
		if (big != small) {
			parent[big] = small;
			return true;
		}
		return false;
	}
}
