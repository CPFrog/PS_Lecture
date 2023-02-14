package part1.week01.B_Tuesday;

import java.util.Arrays;

public class NextPerm {
//	static int[] p = { 0, 0, 1, 2, 3 };
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n;
	static int count;

	public static void main(String[] args) {
		n = p.length;
		int r = 3;
		int[] ans = new int[r];
		do {
			count++;
//			for (int i = 0; i < n; i++) {
//				if (p[i] != 0)
//					ans[p[i] - 1] = arr[i];
//			}
			if(count%2==1)
				System.out.println(Arrays.toString(Arrays.copyOf(p, 3)));
		} while (np(n - 1));
//		System.out.println(count);
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && p[i - 1] > p[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (p[i - 1] > p[j])
			j--;
		int tmp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = tmp;
		int k = size;
		while (i < k) {
			tmp = p[i];
			p[i++] = p[k];
			p[k--] = tmp;
		}
		return true;
	}

}
