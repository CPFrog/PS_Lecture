package part1.week01.A_Monday.live;

import java.util.Scanner;

public class HanoiTest {
	static int n;

	public static void Hanoi(int start, int tmp, int end, int size, int plateno) {
		if (size == 1)
			System.out.println(plateno + "번 원판: " + start + "→" + end);
		else {
			Hanoi(start, end, tmp, size - 1, plateno - 1);
			System.out.println(plateno + "번 원판: " + start + "→" + end);
			Hanoi(tmp, start, end, size - 1, plateno - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Hanoi(1, 2, 3, n, n);
	}
}
