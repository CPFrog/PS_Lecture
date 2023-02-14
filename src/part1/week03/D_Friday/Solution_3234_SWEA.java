package part1.week03.D_Friday;

import java.io.*;
import java.util.StringTokenizer;

// 불가
public class Solution_3234_SWEA {
	static int totalsum, cnt, n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			totalsum=0;
			cnt=0;
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] weight = new int[n];
			for (int i = 0; i < n; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				totalsum+=weight[i];
			}
			dfs(0,0,0,0, weight);
			bw.append("#"+t+" "+cnt+"\n");
		}
		bw.flush();
	}
	
	static void dfs(int depth, int flag, int left, int right, int[] weight) {
		if(depth==n) {
			cnt++;
			return;
		}
		for(int i=0;i<n;i++) {
			if((flag&(1<<i))!=0) continue;
			if(right+weight[i]<=left) 
				dfs(depth+1,flag|(1<<i),left, right+weight[i],weight);
			dfs(depth+1,flag|(1<<i),left+weight[i],right,weight);
		}
	}
}
