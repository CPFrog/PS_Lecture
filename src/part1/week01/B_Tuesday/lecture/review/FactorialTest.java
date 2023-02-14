package part1.week01.B_Tuesday.lecture.review;

public class FactorialTest {
	public static void main(String[] args) {
		for (int i = 1; i < 13; i++)
			System.out.println(i + "!= " + fact(i));
	}

	private static int fact(int i) {
		if (i == 1 || i == 0)
			return 1;
		else
			return i * fact(i - 1);
	}
}
