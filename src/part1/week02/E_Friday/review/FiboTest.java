package part1.week02.E_Friday.review;

public class FiboTest {
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++)
			System.out.println(fibo(i));
	}

	private static int fibo(int n) {
		if (n < 2)
			return n;
		else
			return fibo(n - 1) + fibo(n - 2);

	}
}
