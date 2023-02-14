package part1.week04.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_SWEA {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append("#" + t + " ");
			int parent[] = new int[n];
			for (int i = 0; i < n; i++)
				parent[i] = i;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				if (op == 0) {
					int pa = getParent(parent, a);
					int pb = getParent(parent, b);
					int small = pa > pb ? pb : pa;
					int big = pa > pb ? pa : pb;

					parent[big] = small;	
				} else
					sb.append(getParent(parent, a) == getParent(parent, b) ? 1 : 0);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static int getParent(int[] parent, int a) {
		if (parent[a] != a)
			parent[a] = getParent(parent, parent[a]);
		return parent[a];
	}
}
