package part1.week03.D_Friday;

import java.io.*;
import java.util.*;

public class Solution_3234_SWEA_NxtPerm {
	static int cnt;
	static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			cnt = 0;
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] weight = new int[n];
			for (int i = 0; i < n; i++) 
				weight[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(weight);
			do {
				go(0, 0, 0, weight);
			} while (np(weight));
			bw.append("#" + t + " " + cnt + "\n");
		}
		bw.flush();
	}

	private static boolean np(int[] weight) {
		int size = weight.length - 1;
		int i = size;
		while (i > 0 && weight[i - 1] >= weight[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (weight[i - 1] >= weight[j])
			j--;
		swap(weight, i - 1, j);
		int k = size;
		while (i < k)
			swap(weight, i++, k--);

		return true;
	}

	private static void swap(int[] weight, int from, int to) {
		int tmp = weight[from];
		weight[from] = weight[to];
		weight[to] = tmp;
	}

	private static void go(int depth, int left, int right, int[] weight) {
		if (depth == n) {
			cnt++;
			return;
		}
		if (right + weight[depth] <= left)
			go(depth + 1, left, right + weight[depth], weight);
		go(depth + 1, left + weight[depth], right, weight);
	}
}
