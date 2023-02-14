package part1.week01.A_Monday.live;

import java.util.Scanner;

public class FactorialTest1 {

	static long factorial1(int n) {
		long res = 1L;
		for (int i = n; i >= 1; i--) {
			res *= i;
		}
		return res;
	}

	static long factorial2(int n) {
		if (n == 1)
			return 1L;
		else
			return n * factorial2(n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		long start=System.nanoTime();
		System.out.println(factorial1(n));
		System.out.println("반복문 걸린 시간: "+(System.nanoTime()-start));
		start=System.nanoTime();
		System.out.println(factorial2(n));
		System.out.println("재귀 걸린 시간: "+(System.nanoTime()-start));
	}
}
