package part1.week02.E_Friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1679_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int[] cards = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			q.offer(cards[i]);
		}
		int limits = Integer.parseInt(br.readLine());
		final int MAX_VAL = cards[n - 1] * limits;
		int dp[] = new int[MAX_VAL + 1];

		for (int cardval : cards)
			dp[cardval] = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (dp[cur] == limits)
				continue;
			for (int cardval : cards) {
				if (dp[cur + cardval] == 0) {
					dp[cur + cardval] = dp[cur] + 1;
					q.offer(cur + cardval);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= MAX_VAL; i++) {
			if (dp[i] == 0) {
				if (i % 2 == 0)
					sb.append("holsoon");
				else
					sb.append("jjaksoon");
				sb.append(" win at " + i);
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
