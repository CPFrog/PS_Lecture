package part1.week02.B_Tuesday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		int n = 5;
		int[] arr = new int[n];
		int size = 0;

		List<Integer> arrlist = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		int temp = sc.nextInt();
		arr[size] = temp;
		arrlist.add(temp);

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrlist.toArray()));

	}

}
