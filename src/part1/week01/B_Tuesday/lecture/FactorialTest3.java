package part1.week01.B_Tuesday.lecture;

import java.util.Arrays;

// dp를 이용한 팩토리얼 문제 풀이 - Bottom-UP (tablization)
public class FactorialTest3 {

	static int[] fact;

	public static void main(String[] args) {
		fact = new int[14];
		Arrays.fill(fact, -1);
		fact[0] = 1;
		fact[1] = 1;
		for (int i = 2; i < 14; i++)
			fact[i] = i * fact[i - 1];
		System.out.println(Arrays.toString(fact));
	}
}
