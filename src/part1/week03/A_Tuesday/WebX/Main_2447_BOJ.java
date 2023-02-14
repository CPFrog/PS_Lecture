package part1.week03.A_Tuesday.WebX;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main_2447_BOJ {
	public static boolean[][] star;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		star = new boolean[n][n];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		makeSquares(0, 0, n);
		for (int i = 0; i < n; i++) {
			for (boolean j : star[i])
				bw.append(j ? "*" : " ");
			bw.append("\n");
		}
		bw.flush();

	}

	private static void makeSquares(int startR, int startC, int size) {
		if (size == 3) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (i == 1 && j == 1)
						continue;
					star[startR + i][startC + j] = true;
				}
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue;
				makeSquares(startR + (size / 3) * i, startC + (size / 3) * j, size / 3);
			}
		}
		return;
	}
}
