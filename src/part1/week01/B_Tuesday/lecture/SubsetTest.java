package part1.week01.B_Tuesday.lecture;

import java.util.Arrays;

public class SubsetTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static int count;
	static boolean[] isVisited;

	public static void main(String[] args) {
		isVisited = new boolean[n];
		subset(0);
		System.out.println(count);
		System.out.println((1 << n));
	}

	private static void subset(int cnt) {
		if (cnt == n) {
			count++;
			// 선택된것 출력
			for (int i = 0; i < n; i++) {
				if (isVisited[i])
					System.out.print(p[i] + " ");
			}
			System.out.println();
			return;
		}
		isVisited[cnt] = true;
		subset(cnt + 1);
		isVisited[cnt] = false;
		subset(cnt + 1);

	}

}
