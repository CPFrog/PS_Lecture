package part2.week03.A_221011.DIY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_15961_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int plate[] = new int[n * 3];

		Deque<Integer> q = new ArrayDeque<>();
		int curMax = 0;
		int kind = 0;
		int plateCnt[] = new int[3001];
		for (int i = 0; i < n; i++) {
			plate[i] = Integer.parseInt(br.readLine());
			if (i < k) {
				q.offerLast(plate[i]);
				plateCnt[plate[i]]++;
				if (plateCnt[plate[i]] == 1)
					kind++;
			}
		}
		curMax = kind;
		for (int i = 0; i < n - 1; i++) {
			int front = q.pollFirst();
			if ((--plateCnt[front]) == 0)
				kind--;
			int next = plate[(i + k) % n];
			q.offerLast(next);
			if ((++plateCnt[next]) == 1)
				kind++;
			if (plateCnt[c] == 0) {
				if (kind + 1 > curMax)
					curMax = kind + 1;
			}
			else if (kind > curMax)
				curMax = kind;
		}
		System.out.println(curMax);
	}
}
