package part1.week01.D_Thursday.live.Definition;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest2 {
	static int n;
	static int totalCnt = 0;
	static int[] numbers, input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		totalCnt = 0;

		numbers = new int[n];
		input = new int[n];
		isSelected = new boolean[n + 1];
		for (int i = 0; i < n; i++)
			input[i] = sc.nextInt();

		perm(0);
		System.out.println("총 경우의 수: " + totalCnt);
	}

	private static void perm(int cnt) {
		if (cnt == n) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (isSelected[i])
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}

}
