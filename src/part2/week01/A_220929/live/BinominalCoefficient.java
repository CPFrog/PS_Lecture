package part2.week01.A_220929.live;

import java.util.Scanner;

// 이항계수
public class BinominalCoefficient {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		int[][] b=new int[n+1][k+1];
		for(int i=0;i<=n;i++) {
			int end=Math.min(i, k);
			for(int j=0;j<=end;j++) {
				if(j==0 || j==i)
					b[i][j]=1;
				else
					b[i][j]=b[i-1][j-1]+b[i-1][j];
			}
		}
		System.out.println(b[n][k]);
	}

}
