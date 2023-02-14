package part1.week01.D_Thursday.live.Definition;

import java.util.Scanner;

public class SubSetTest {
	static int n;
	static int totalCnt;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		totalCnt = 0;
		input = new int[n];
		isSelected = new boolean[n];
		for (int i = 0; i < n; i++)
			input[i] = i + 1;
		subset(0);
	}

	private static void subset(int index) {
		if (index == n) { // 더이상 고려할 원소가 없다면 부분집합의 구성이 완성된 것!
			for (int i = 0; i < n; i++) {
				if (isSelected[i])
					System.out.print(input[i] + " ");
				else System.out.print("_ ");
			}
			System.out.println();
			return;
		}
		isSelected[index] = true;
		subset(index + 1);
		isSelected[index] = false;
		subset(index + 1);
	}
}
