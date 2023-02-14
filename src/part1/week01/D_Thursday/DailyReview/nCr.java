package part1.week01.D_Thursday.DailyReview;

import java.io.*;
import java.util.Arrays;

public class nCr {
	static int[] arr;
	static int[] ans;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append("n 입력: ");
		bw.flush();
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		bw.append("r 입력: ");
		bw.flush();
		int r = Integer.parseInt(br.readLine());
		ans = new int[r];
		ncr(n, r, 0, 0);

	}

	private static void ncr(int n, int r, int pos, int level) throws Exception {
		if (level == r) {
			bw.append(Arrays.toString(ans) + "\n");
			bw.flush();
			return;
		}
		for (int i = pos; i < n; i++) {
			ans[level] = arr[i];
			ncr(n, r, i + 1, level + 1);
		}
	}
}
