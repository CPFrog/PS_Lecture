package part1.week02.E_Friday.review;

public class FactTest_Table {
	public static void main(String[] args) {
		int n = 13;
		int[] fact = new int[n];
		fact[1] = 1;
		for (int i = 2; i <= 13; i++) 
			fact[i] = fact[i - 1] * i;
		System.out.println(fact[n]);
	}

}
