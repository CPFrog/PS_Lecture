package part1.week01.C_Wednesday.lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_BOJ {
	static int n, goal;
	static int[] list;
	static boolean[] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		list = new int[n];
		isVisited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			list[i] = Integer.parseInt(st.nextToken());
		int nearestVal = blackjack(0, 0);
		System.out.println(nearestVal);

	}

	private static int blackjack(int hand, int level) {
		int nearest = Integer.MAX_VALUE;
		if (level == 3) {
			return hand;
		}
		for (int i = 0; i < n; i++) {
			if (isVisited[i])
				continue;
			isVisited[i] = true;
			int tmp = blackjack(hand + list[i], level + 1);
			if (tmp <= goal && Math.abs(nearest - goal) > Math.abs(tmp - goal))
				nearest = tmp;
			isVisited[i] = false;
		}
		return nearest;
	}

}
