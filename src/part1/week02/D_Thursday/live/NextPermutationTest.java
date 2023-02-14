package part1.week02.D_Thursday.live;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++)
			input[i] = sc.nextInt();
		Arrays.sort(input);

	}

	public static boolean np(int[] numbers) {
		int n = numbers.length;
		int i = n - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			i--;
		if (i == 0)
			return false;
		int j = n - 1;
		while (numbers[i - 1] >= numbers[j])
			j--;

		swap(numbers, i - 1, j);

		int k = n - 1;
		while (i < k) {
			swap(numbers, i, k);
			i++;
			k--;
		}
		return true;
	}

	public static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

}
