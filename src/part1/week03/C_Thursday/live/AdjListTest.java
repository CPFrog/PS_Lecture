package part1.week03.C_Thursday.live;

import java.util.Scanner;

public class AdjListTest {
	static int n;
	static Node[] adjList;
	static boolean[] visited;

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int e = sc.nextInt();

		adjList = new Node[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		dfs(0);
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.println((char) (cur + 'A'));

		for (Node tmp = adjList[cur]; tmp != null; tmp = tmp.next) {
			if (!visited[tmp.to]) {
				dfs(tmp.to);
			}
		}

	}

}
