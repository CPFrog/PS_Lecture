package part2.week01.A_220929.live;

import java.util.Scanner;

public class ChangeMinCoinTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int money=sc.nextInt();
		
		int[] coins= {1,4,6};
		int[] arr=new int[money+1]; // arr[i] : i 금액을 만드는 최소 동전 수
		
		final int INF=Integer.MAX_VALUE;
		arr[0]=0;
		for(int i=1;i<=money;i++) {
			int min=INF;
			min=Math.min(min, arr[i-1]+1);
		}
		
		System.out.println(arr[money]);
	}

}
