package part1.week02.B_Tuesday.review;

public class PowerSet {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;

	public static void main(String[] args) {
		for (int i = 0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0)
					continue;
				System.out.print(p[j]+" ");
			}
			System.out.println();
		}
	}

}
