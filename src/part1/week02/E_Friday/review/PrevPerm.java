package part1.week02.E_Friday.review;

import java.util.Arrays;

public class PrevPerm {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static int count;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		do {
			count++;
			sb.append(Arrays.toString(p) + "\n");
		} while (np(n - 1));
		System.out.println(sb.toString());
		System.out.println(count);
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
		swap(p, i - 1, j);
		int k = size;
		while (i < k) {
			swap(p, i, k);
			i++;
			k--;
		}

		return true;
	}

	private static void swap(int[] arr, int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}

}
