package part1.week03.A_Tuesday.live;

import java.util.Scanner;

public class VendingMachineTest {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();

		int[] units = { 500, 100, 50, 10, 5, 1 };
		int[] counts = { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() };

		int total = 0;
		for (int i = 0, size = units.length; i < size; i++) {
			total += units[i] * counts[i];
		}

		int remains = total - target;

		int sum = 0, maxCnt, availCnt;
		for (int i = 0, size = units.length; i < size; i++) {
			maxCnt = remains / units[i];
			availCnt = maxCnt <= counts[i] ? maxCnt : counts[i];

			counts[i] -= availCnt;
			remains -= availCnt * units[i];

			sum += counts[i];

		}
		System.out.println(sum);
		
		for(int i=0,size=counts.length;i<size;i++)
			System.out.print(counts[i]+" ");

	}

}
