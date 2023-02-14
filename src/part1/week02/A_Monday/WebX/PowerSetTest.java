package part1.week02.A_Monday.WebX;

public class PowerSetTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;

	public static void main(String[] args) {
		// shift 연산자
		// 이진수 : 10001
		// 자리수 : 1 5
		// 1<<0 : 00001
		// 1<<1 : 00010
		// 1<<2 : 00100
		// 1<<3 : 01000
		// 1<<4 : 10000

		for (int i = 0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) 
					System.out.print(p[j] + " ");
			}
			System.out.println();
		}
	}

}
