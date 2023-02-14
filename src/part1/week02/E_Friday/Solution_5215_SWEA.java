package part1.week02.E_Friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_SWEA {
	static int n;
	static int[][] info;
	static int limits;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			limits = Integer.parseInt(st.nextToken());
			info = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++)
					info[i][j] = Integer.parseInt(st.nextToken());
			}
			sb.append("#" + t + " " + subset(0, 0, 0)+"\n");
		}
		System.out.println(sb.toString());
	}

	private static int subset(int depth, int flag, int calSum) {
		if (calSum > limits)
			return Integer.MIN_VALUE;
		if (depth == n)
			return getResult(flag);
		int maxVal = subset(depth + 1, flag | (1 << depth), calSum + info[depth][1]);
		int tmp = subset(depth + 1, flag, calSum);
		return maxVal > tmp ? maxVal : tmp;
	}

	private static int getResult(int flag) {
		int satis = 0;
		for (int i = 0; i < n; i++)
			if ((flag & (1 << i)) != 0)
				satis += info[i][0];
		return satis;
	}

}
