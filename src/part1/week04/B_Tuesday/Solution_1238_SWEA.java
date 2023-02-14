package part1.week04.B_Tuesday;

import java.io.*;
import java.util.*;

public class Solution_1238_SWEA {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken()) - 1;
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer>[] childList = new ArrayList[100];
			for (int i = 0; i < 100; i++)
				childList[i] = new ArrayList<>();

			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				if(from!=to)
					childList[from].add(to);
			}
			boolean[] visited = new boolean[100];
			sb.append("#" + t + " " + bfs(childList, start, visited) + "\n");
		}
		System.out.print(sb.toString());
	}

	private static int bfs(ArrayList<Integer>[] childList, int start, boolean[] visited) {
		PriorityQueue<Integer> q=new PriorityQueue<>();
		PriorityQueue<Integer> nextq=new PriorityQueue<>();
		q.offer(start);
		visited[start]=true;
		int ans=start;
		int cnt=0;
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(int i:childList[cur]) {
				if(!visited[i]) {
					visited[i]=true;
					nextq.offer(i);
				}
			}
			if(q.isEmpty()) {
				q.addAll(nextq);
				nextq=new PriorityQueue<>();
				ans=cur;
			}
		}
		return ans+1;
	}
}
