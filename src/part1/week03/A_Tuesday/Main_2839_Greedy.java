package part1.week03.A_Tuesday;

import java.util.Scanner;

public class Main_2839_Greedy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(getBags(sc.nextInt()));
	}

	private static int getBags(int candies) {
		if (candies > 0 && candies < 3)
			return -1;

		if (candies % 5 == 0)
			return candies / 5;
		else {
			int tmp = getBags(candies - 3);
			if (tmp == -1)
				return tmp;
			else
				return tmp + 1;
		}
	}
}
