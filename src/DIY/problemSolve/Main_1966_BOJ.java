package DIY.problemSolve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1966_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			PriorityQueue<Document> q = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				q.offer(new Document(i + 1, Integer.parseInt(st.nextToken())));
			
			int cnt=0;
			while(!q.isEmpty()) {
				cnt++;
				Document cur=q.poll();
				System.out.println(cur);
				if(cur.name==m)
					break;
			}
			System.out.println(cnt);
			T--;
		}
	}

	static class Document implements Comparable<Document> {
		int name, priority;

		public Document(int name, int priority) {
			this.name = name;
			this.priority = priority;
		}

		@Override
		public int compareTo(Document o) {
			return this.priority != o.priority ? -(this.priority - o.priority) : -(this.name - o.name);
		}

		@Override
		public String toString() {
			return "Document [name=" + name + ", priority=" + priority + "]";
		}
		
	}
}
