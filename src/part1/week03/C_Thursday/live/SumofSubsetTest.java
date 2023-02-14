package part1.week03.C_Thursday.live;

import java.util.Scanner;

public class SumofSubsetTest {
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
		subset(0,0);
		System.out.println("총 경우의 수:"+totalCnt);
	}

	private static void subset(int index, int sum) {
		if (index == n) { // 더이상 고려할 원소가 없다면 부분집합의 구성이 완성된 것!
			totalCnt++;
			for(int i=0;i<n;i++) {
				System.out.print((isSelected[i]?input[i]:"_")+" ");
			}
			System.out.println();
			return;
		}
		isSelected[index] = true;
		subset(index + 1,sum+input[index]);
		isSelected[index] = false;
		subset(index + 1,sum);
	}
}
