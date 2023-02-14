package part1.week02.A_Monday.WebX.review;

import java.util.Arrays;

public class CombiTest {
	static int[] p= {1,2,3,4,5};
	static int n=p.length;
	static int r;
	static int count;
	static int[] nums;
	public static void main(String[] args) {
		r=3;
		nums=new int[r];
		combi(0);
		System.out.println(count);
	}
	private static void combi(int cnt) {
		if(cnt==r) {
			cnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for(int i=0;i<n;i++) {
			nums[cnt]=p[i];
			combi(cnt+1);
			nums[cnt]=0;
		}
	}

}
