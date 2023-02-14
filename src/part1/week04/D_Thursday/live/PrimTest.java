package part1.week04.D_Thursday.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimTest {
	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
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
		boolean visited[] = new boolean[v];

		Arrays.fill(minEdge, Integer.MAX_VALUE); // 각 노드별로 최소 거리를 저장하기 위해 21억이라는 도달 불가 값 넣음.

		// 1. 임의의 시작점 처리(0번 정점을 신장트리의 루트노드로 지정)
		minEdge[0] = 0;
		int result = 0; // MST의 전체 비용 저장

		for (int c = 0; c < v; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int i = 0; i < v; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			//2. 신장트리에 추가
			visited[minVertex]=true;
			result+=min;
			
			//3. 신장트리에 새롭게 추가되는 정점과 포함되지 않은 정점들의 기존 최소비용과 비교하여 갱신. 
			// 새롭게 추가되는 정점의 모든 인접정점 순회함
			
			for(Node tmp=adjList[minVertex];tmp!=null;tmp=tmp.next) {
				if(!visited[tmp.vertex]&&minEdge[tmp.vertex]>tmp.weight)
					minEdge[tmp.vertex]=tmp.weight;
			}
		}
		
	}
}
