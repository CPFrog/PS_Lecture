package part2.week02.D_221007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_BOJ {
	static int n;
	static ArrayList<Integer>[] team;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] people = new int[n];
		for (int i = 0; i < n; i++)
			people[i] = Integer.parseInt(st.nextToken());
		ArrayList<Integer> map[] = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			map[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for (int j = 0; j < len; j++)
				map[i].add(Integer.parseInt(st.nextToken()) - 1);
		}

		int curMin = Integer.MAX_VALUE;
		for (int i = 1; i < (1 << n) - 1; i++) {
			int diff = getDiff(people, i);
			if (diff < curMin && canGo(map, i, 0) && canGo(map, i, 1)) {
				curMin = diff;
			}
		}
		if (curMin == Integer.MAX_VALUE)
			curMin = -1;
		System.out.println(curMin);
	}

	private static boolean canGo(ArrayList<Integer>[] map, int flag, int teamNo) {
		Queue<Integer> q = new LinkedList<>();
		int start = 0;
		boolean[] visited = new boolean[n];
		start = team[teamNo].get(0);
		q.offer(start);
		visited[start] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : map[cur]) {
				if (team[teamNo].contains(next) && !visited[next]) {
					visited[next] = true;
					cnt++;
					q.offer(next);
				}
			}
		}
		return cnt == team[teamNo].size();
	}

	private static int getDiff(int[] people, int teamFlag) {
		int groupA = 0, groupB = 0;
		team = new ArrayList[2];
		team[0] = new ArrayList<>();
		team[1] = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (((1 << i) & teamFlag) > 0) {
				groupA += people[i];
				team[0].add(i);
			} else {
				groupB += people[i];
				team[1].add(i);
			}
		}
		return Math.abs(groupA - groupB);
	}
}
