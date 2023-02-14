package part1.week02.D_Thursday.live;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitMaskingTest {
	static int n, r;
	static int totalCnt = 0;
	static int[] numbers, input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		totalCnt = 0;

		input = new int[n];
		numbers = new int[r];
		for (int i = 0; i < n; i++)
			input[i] = sc.nextInt();

		perm(0, 0);
		System.out.println("총 경우의 수: " + totalCnt);
	}

	private static void perm(int cnt, int flag) {
		if (cnt == n) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			numbers[cnt] = i;
			perm(cnt + 1, flag | (1 << i));
		}
	}

}
