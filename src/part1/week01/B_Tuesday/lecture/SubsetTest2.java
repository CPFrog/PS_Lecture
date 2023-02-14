package part1.week01.B_Tuesday.lecture;

import java.util.Arrays;

public class SubsetTest2 {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static int count;
	static boolean[] isVisited;

	public static void main(String[] args) {
		isVisited = new boolean[n];
		subset(0, 0);
		System.out.println(count);
		System.out.println((1 << n));
	}

	private static void subset(int cnt, int total) {
		if (cnt == n) {
			count++;
			// 선택된것 출력
			for (int i = 0; i < n; i++) {
				if (isVisited[i])
					System.out.print(p[i] + " ");
			}
			System.out.println();
			System.out.println("└──── 총합: " + total);
			return;
		}
		isVisited[cnt] = true;
		subset(cnt + 1, total + p[cnt]);
		isVisited[cnt] = false;
		subset(cnt + 1, total);
	}
}
