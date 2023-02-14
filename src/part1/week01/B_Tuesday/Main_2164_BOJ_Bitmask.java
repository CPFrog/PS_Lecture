package part1.week01.B_Tuesday;

import java.util.Scanner;

public class Main_2164_BOJ_Bitmask {
	static boolean[] visit;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		visit = new boolean[n];
		int pos = 0;
		for (int i = 0; i < n - 1; i++) {
			visit[pos] = true;
			pos = getNext(pos, 0);
		}
		System.out.println(pos + 1);
	}

	private static int getNext(int pos, int depth) {
		if (depth == 2)
			return pos;
		int tmp = pos + 1;

		do {
			if (tmp >= n)
				tmp -= n;

			if (!visit[tmp])
				break;
			tmp++;
		} while (true);

		return getNext(tmp, depth + 1);
	}
}
