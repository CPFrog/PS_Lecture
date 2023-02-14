package part1.week01.E_Friday.DIY;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main_2023_BOJ {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		boolean[] sieve = new boolean[(int) 1e+8];
		int start = 1;
		for (int i = 1; i < n; i++)
			start *= 10;
		int end = start * 10;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = start; i < end; i++) {
			if (isPrime(i))
				bw.append(i + "\n");
		}
		bw.flush();
		bw.close();
		sc.close();
	}

	private static boolean isPrime(int num) {
		if (num == 1)
			return false;
		for (int i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;
		if (num < 10)
			return true;
		return isPrime(num / 10);
	}

}
