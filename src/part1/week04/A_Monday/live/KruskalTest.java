package part1.week04.A_Monday.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalTest {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Edge o) {
//			return Integer.compare(this.weight, o.weight);
			return this.weight - o.weight;
		}
	}

	static int[] parents;
	static int V, E;
	static Edge[] edgeList;

	static void make() {
		parents=new int[V];
		for (int i = 0; i < V; i++)
			parents[i] = i;
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		edgeList=new Edge[E];
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			edgeList[i]=new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		make();
		Arrays.sort(edgeList);
		
		int result=0, count=0;
		for(Edge e:edgeList) {
			if(union(e.from, e.to)) {
				result+=e.weight;
				if(++count==V-1) break;
			}
		}
		System.out.println(result);
	}
}
