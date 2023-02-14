package part1.week02.B_Tuesday;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_6808_SWEA {
	static int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
	static int[] iy;
	static int[] dp = new int[9];
	static int n = 18, r = 9;
	static boolean[] check;
	static int lose, win;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int t = 1; t <= T; t++) {
			lose = 0;
			win = 0;
			iy = new int[9];
			check = new boolean[18];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				iy[i] = Integer.parseInt(st.nextToken());
				check[iy[i] - 1] = true;
				if (i == 0)
					dp[i] = iy[i];
				else
					dp[i] = iy[i] + dp[i - 1];
			}
			npr(0, 0, 0);
			bw.append("#" + t + " " + lose + " " + win + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void npr(int Iscore, int Kscore, int depth) {
		if (depth == r) {
			if (Iscore > Kscore)
				lose++;
			else if (Iscore < Kscore)
				win++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (check[i])
				continue;
			check[i] = true;
			int sum = iy[depth] + arr[i];

			if (iy[depth] > arr[i])
				npr(Iscore + sum, Kscore, depth + 1);
			else if (iy[depth] < arr[i])
				npr(Iscore, Kscore + sum, depth + 1);
			check[i] = false;
		}
	}
}
