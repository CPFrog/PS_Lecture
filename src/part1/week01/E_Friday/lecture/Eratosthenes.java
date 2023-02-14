package part1.week01.E_Friday.lecture;

public class Eratosthenes {
	static boolean prime[];

	public static void main(String[] args) {
		prime = new boolean[1001];
		for (int i = 2; i <= 1000; i++) {
			if (isPrime(i))
				System.out.print(i + " ");
			System.out.println();
		}
	}

	private static boolean isPrime(int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
