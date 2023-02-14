package part1.week03.A_Tuesday;

import java.util.Scanner;

public class Main {
	static int d = 0;
	static int s = 0;
	static int R, C;
	static int[] pos = new int[2];
	static boolean stop;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();

		find(0, 0, (int) Math.pow(2, N));

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (i + pos[0] == R && j + pos[1] == C) {
					System.out.println(s);
				}
				s++;
			}
		}
	}

	private static void find(int r, int c, int n) {
		if (n == 2) {
			s = d * 4;
			d++;
			if (r <= R && R <= r + 1 && c <= C && C <= c + 1) {
				pos[0] = r;
				pos[1] = c;
				stop = true;
			}
		} else {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					find(r + i * n / 2, c + j * n / 2, n / 2);
					if (stop)
						return;
				}
			}
		}
	}
}