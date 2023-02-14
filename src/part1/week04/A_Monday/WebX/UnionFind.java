package part1.week04.A_Monday.WebX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UnionFind {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int edgeN = Integer.parseInt(br.readLine());
		ArrayList<Integer> adjList[] = new ArrayList[n];
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
			parent[i] = i;
		}
		StringTokenizer st;
		for (int i = 0; i < edgeN; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int minNum = from > to ? to : from;
			int maxNum = from > to ? from : to;

			adjList[minNum].add(maxNum);
			parent[maxNum] = minNum;
			if (adjList[maxNum].size() > 0) {
				for (int j : adjList[maxNum])
					parent[j] = minNum;
			}
		}
		st = new StringTokenizer(br.readLine());

		int node1 = Integer.parseInt(st.nextToken()) - 1;
		int node2 = Integer.parseInt(st.nextToken()) - 1;

		System.out.println(parent[node1] == parent[node2]);
	}

}
