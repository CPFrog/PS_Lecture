package part1.week04.D_Thursday.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest_PQ {
	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight != o.weight ? this.weight - o.weight : this.no - o.no;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[v];

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			// 방향성 없는 그래프이므로
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(to, weight, adjList[to]);
		}

		int[] minEdge = new int[v];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		boolean visited[] = new boolean[v];

		PriorityQueue<Vertex> q = new PriorityQueue<>();

		int result = 0;
		int cnt = 0; // 연결된 노드 개수

		while (!q.isEmpty()) {
			// 1. 임의의 시작점 처리(0번 정점을 신장트리의 루트노드로 지정)
			Vertex minVertex = q.poll();

			if (visited[minVertex.no])
				continue;

			// 2. 신장트리에 추가
			visited[minVertex.no] = true;
			result += minVertex.weight;
			if (++cnt == v)
				break; // 연결된 노드 개수가 전체 개수와 같아지면 탈출

			// 3. 신장트리에 새롭게 추가되는 정점과 포함되지 않은 정점들의 기존 최소비용과 비교하여 갱신.
			// 새롭게 추가되는 정점의 모든 인접정점 순회하며 처리

			for (Node tmp = adjList[minVertex.no]; tmp != null; tmp = tmp.next) {
				if (!visited[tmp.vertex] && minEdge[tmp.vertex] > tmp.weight) {
					minEdge[tmp.vertex] = tmp.weight;
					q.offer(new Vertex(tmp.vertex, minEdge[tmp.vertex]));
				}
			}
		}
		System.out.println(result);
	}
}
