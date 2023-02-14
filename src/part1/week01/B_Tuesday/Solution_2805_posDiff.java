package part1.week01.B_Tuesday;

import java.util.Scanner;

public class Solution_2805_posDiff {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			long sum = 0;
			int dist = n / 2;
			for (int i = 0; i < n; i++) {
				String line = sc.next();
				for (int j = 0; j < n; j++) {
					if (Math.abs(dist - i) + Math.abs(dist - j) <= dist) {
						sum += line.charAt(j) - '0';
					}
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}

}
