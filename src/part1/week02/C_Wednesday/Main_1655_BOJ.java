package part1.week02.C_Wednesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxpq = new PriorityQueue<>();
		PriorityQueue<Integer> minpq = new PriorityQueue<>(Collections.reverseOrder());
		minpq.offer(Integer.parseInt(br.readLine()));
		sb.append(minpq.peek() + "\n");
		for (int i = 1; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			maxpq.offer(input);
//			System.out.println(minpq.size()+" "+maxpq.size()+" "+minpq.peek()+" "+maxpq.peek());
			if (maxpq.peek() < minpq.peek()) {
				maxpq.offer(minpq.poll());
				minpq.offer(maxpq.poll());
			}
			while (minpq.size() <= i / 2) {
				minpq.offer(maxpq.poll());
			}

			System.out.println(minpq.size() + " " + maxpq.size() + " " + minpq.peek() + " " + maxpq.peek());
			sb.append(minpq.peek() + "\n");
		}
		System.out.println(sb.toString());
	}
}
