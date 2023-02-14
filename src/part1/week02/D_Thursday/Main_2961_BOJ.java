package part1.week02.D_Thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_BOJ {
	static int n;
	static int[][] taste;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		taste = new int[n][2];
		int bm = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dp(0, bm, 1, 0));

	}

	private static int dp(int depth, int bitMask, int sourness, int bitterness) {
		int curMin = Integer.MAX_VALUE;
		if (depth == n) {
			if (bitMask == 0)
				return curMin;
			else
				return Math.abs(sourness - bitterness);
		}
		int tmp = dp(depth + 1, bitMask | (1 << depth), sourness * taste[depth][0], bitterness + taste[depth][1]);
		if (tmp < curMin)
			curMin = tmp;
		tmp = dp(depth + 1, bitMask, sourness, bitterness);
		if (tmp < curMin)
			curMin = tmp;

		return curMin;
	}

}
