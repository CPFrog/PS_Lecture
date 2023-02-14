package part1.week02.C_Wednesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_4008_DFS_Pruning {

	static int T;
	static int N;
	static int[] ops;
	static int[] nums;
	static int max, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ops = new int[5];
			nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 5; i++) {
				ops[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			max = -1000000000;
			min = 1000000000;
			dfs(0, ops[1], ops[2], ops[3], ops[4], new int[N - 1]);
			System.out.println("#" + t + " " + (max - min));
		}
	}

	private static void dfs(int cnt, int p, int m, int x, int d, int[] opps) {

		if (p < 0 || m < 0 || x < 0 || d < 0) {
			return;
		}
		if (cnt == N - 1) {
			int sum = nums[0];
			for (int i = 0; i < N - 1; i++) {
				if (opps[i] == 1) {
					sum = (sum + nums[i + 1]);
				} else if (opps[i] == 2) {
					sum = (sum - nums[i + 1]);
				} else if (opps[i] == 3) {
					sum = (sum * nums[i + 1]);
				} else if (opps[i] == 4) {
					sum = (sum / nums[i + 1]);
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		opps[cnt] = 1;
		dfs(cnt + 1, p - 1, m, x, d, opps);
		opps[cnt] = 2;
		dfs(cnt + 1, p, m - 1, x, d, opps);
		opps[cnt] = 3;
		dfs(cnt + 1, p, m, x - 1, d, opps);
		opps[cnt] = 4;
		dfs(cnt + 1, p, m, x, d - 1, opps);
		opps[cnt] = 0;
	}

}