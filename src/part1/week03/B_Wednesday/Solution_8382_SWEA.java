package part1.week03.B_Wednesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8382_SWEA {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());

			int dr = Math.abs(endR - startR);
			int dc = Math.abs(endC - startC);
			int min = dr > dc ? dc : dr;
			int max = dr > dc ? dr : dc;
			max -= min;
			int ans = min * 2;
			ans += (max / 2) * 4;
			if (max % 2 == 1) ans++;
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}
}
