package part1.week01.D_Thursday.DailyReview;

import java.io.*;
import java.util.Arrays;

public class nPr {
	static int[] arr;
	static boolean[] v;
	static int[] ans;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append("n 입력: ");
		bw.flush();
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		v = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		bw.append("r 입력: ");
		bw.flush();
		int r = Integer.parseInt(br.readLine());
		ans = new int[r];
		npr(n, r, 0);

	}

	private static void npr(int n, int r, int level) throws Exception {
		if (level == r) {
			bw.append(Arrays.toString(ans) + "\n");
			bw.flush();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				ans[level] = arr[i];
				npr(n, r, level + 1);
				v[i] = false;
			}
		}
	}
}
