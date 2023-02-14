package part2.week01.A_220929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans[][] = new int[2][3];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				int cost=Integer.parseInt(st.nextToken());
				int row=i%2;
				ans[row][j]=getMinPast(ans,row,j)+cost;
			}
		}
		System.out.println(getMinPast(ans,(n+1)%2,3));
	}

	private static int getMinPast(int[][] ans, int i, int j) {
		int min=Integer.MAX_VALUE;
		for(int row=0;row<3;row++) {
			if(j!=row && min>ans[1-i][row])
				min=ans[1-i][row];
		}
		return min;
	}
}
