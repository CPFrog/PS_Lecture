package part1.week01.B_Tuesday.lecture;

import java.util.Arrays;

// dp를 이용한 팩토리얼 문제 풀이 - Top-down ()
public class FactorialTest2 {

	static int[] fact;

	public static void main(String[] args) {
		fact = new int[14];
		Arrays.fill(fact, -1);
		for (int i = 0; i < 14; i++)
			fact[i] = fact(i);
		System.out.println(Arrays.toString(fact));
	}

	private static int fact(int i) {
		if (i == 1 || i == 0)
			return 1;
		else if (fact[i] != -1)
			return fact[i];
		else
			return i * fact(i - 1);
	}
}
