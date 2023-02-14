package DIY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NextPermutation {
	static int[] arr;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		do {
			System.out.println(Arrays.toString(arr));
		} while (np());

	}

	public static boolean np() {
		int i = n - 1;
		while (i > 0 && arr[i - 1] > arr[i])
			i--;
		if (i == 0)
			return false;
		int j = n - 1;
		while (arr[i - 1] > arr[j])
			j--;
		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;
		int k = n - 1;
		while (i < k) {
			tmp = arr[i];
			arr[i++] = arr[k];
			arr[k--] = tmp;
		}
		return true;
	}
}
