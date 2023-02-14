package part1.week02.A_Monday.WebX.review;

import java.util.Arrays;

public class PermTest {
	static int[] p= {1,2,3,4,5};
	static int n=p.length;
	static int r;
	static int count;
	static int[] nums;
	static boolean[] visited;
	public static void main(String[] args) {
		r=3;
		nums=new int[r];
		visited=new boolean[n];
		perm(0);
		System.out.println(count);
	}
	private static void perm(int cnt) {
		if(cnt==r) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for(int i=0;i<n;i++) {
			if(visited[i]) continue;
			visited[i]=true;
			nums[cnt]=p[i];
			perm(cnt+1);
			nums[cnt]=0;
			visited[i]=false;
		}
	}

}
