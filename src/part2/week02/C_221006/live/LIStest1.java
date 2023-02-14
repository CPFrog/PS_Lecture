package part2.week02.C_221006.live;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class LIStest1 {
	public static void main(String[] args) throws Exception {
//		Scanner sc=new Scanner(new FileInputStream("src/part2/week02/C_221006/live/lis_input.txt"));
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		int[] lis=new int[n];
		
		for(int i=0;i<n;i++) 
			arr[i]=sc.nextInt();
		
		int curMax=0;
		for(int i=0;i<n;i++) {
			lis[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]&&lis[i]<lis[j]+1) {
					lis[i]=lis[j]+1;
				}
			}
			curMax=Math.max(curMax, lis[i]);
		}
		System.out.println(Arrays.toString(lis));
		System.out.println(curMax);
	}

}
