package part1.week02.E_Friday;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_BOJ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt();
		int brother = sc.nextInt();
		boolean[] visited = new boolean[100001];
		visited[subin] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { subin, 0 });
		int ans = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int newX = cur[0] + 1;
			if (rangecheck(newX) && !visited[newX]) {
				if (newX == brother) {
					ans = cur[1] + 1;
					break;
				}
				visited[newX] = true;
				q.offer(new int[] { newX, cur[1] + 1 });
			}
			newX = cur[0] - 1;
			if (rangecheck(newX) && !visited[newX]) {
				if (newX == brother) {
					ans = cur[1] + 1;
					break;
				}
				visited[newX] = true;
				q.offer(new int[] { newX, cur[1] + 1 });
			}
			newX = cur[0] * 2;
			if (rangecheck(newX) && !visited[newX]) {
				if (newX == brother) {
					ans = cur[1] + 1;
					break;
				}
				visited[newX] = true;
				q.offer(new int[] { newX, cur[1] + 1 });
			}
		}
		System.out.println(ans);
	}

	static boolean rangecheck(int newX) {
		return newX >= 0 && newX <= 100000;
	}
}
