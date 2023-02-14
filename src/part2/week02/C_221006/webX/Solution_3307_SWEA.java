package part2.week02.C_221006.webX;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3307_SWEA {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/part2/week02/C_221006/SampleTC/SWEA_3307.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[n];
			int[] ans = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				ans[i] = 1;
				for (int j = 0; j < i; j++) {
					// 자기자신 포함하는 경우
					if (arr[i] > arr[j] && ans[i] < ans[j] + 1) {
						ans[i] = ans[j] + 1;
					}
				}
			}
			int curMax = 0;
			for (int tmp : ans)
				if (curMax < tmp)
					curMax = tmp;
			sb.append("#" + t + " " + curMax + "\n");
		}
		System.out.print(sb.toString());
	}
}
