package part2.week01.A_220929.webX;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1463_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];

		go(n, arr);
		System.out.println(arr[n]);
	}

	private static int go(int n, int[] arr) {
		if (arr[n] != 0 || n == 1)
			return arr[n];
		int curMin = go(n - 1, arr) + 1;
		int tmp;
		if (n % 3 == 0) {
			tmp = go(n / 3, arr) + 1;
			if (tmp < curMin)
				curMin = tmp;
		}
		if (n % 2 == 0) {
			tmp = go(n / 2, arr) + 1;
			if (tmp < curMin)
				curMin = tmp;
		}
		return arr[n] = curMin;
	}
}
