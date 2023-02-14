package part1.week02.C_Wednesday;

import java.io.*;
import java.util.*;

public class Main_1927_PQ {
	public static void main(String[] args) throws Exception {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				try {
					bw.append(pq.remove().val + "\n");
				} catch (NoSuchElementException e) {
					bw.append("0\n");
				}
			} else
				pq.add(new Node(input));
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static class Node implements Comparable<Node> {
		int val;

		Node(int val) {
			this.val = val;
		}

		@Override
		public int compareTo(Node target) {
			return Integer.compare(this.val, target.val);
		}
	}
}
