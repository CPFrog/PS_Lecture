package part1.week02.B_Tuesday;

import java.io.*;
import java.util.*;

public class Main_2667_BOJ {
	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		visited = new boolean[size][size];
		List<Integer> danjis=new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			String line = br.readLine();
			for (int j = 0; j < size; j++)
				map[i][j] = line.charAt(j) - '0';
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == 1 && !visited[i][j]) 
					danjis.add(bfs(i, j));
			}
		}
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(danjis.size()+"\n");
		Collections.sort(danjis);
		
		for(int i:danjis)
			bw.append(i+"\n");
		bw.flush();
		br.close();
		bw.close();
	}

	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = true;
		int size = 0;
		q.offer(new int[] { r, c });
		while (!q.isEmpty()) {
			int[] curPos = q.poll();
			size++;
			int curR = curPos[0], curC = curPos[1];
			for (int i = 0; i < 4; i++) {
				int nr = curR + dr[i];
				int nc = curC + dc[i];
				if (rangeCheck(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc]=true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		return size;
	}

	private static boolean rangeCheck(int r, int c) {
		return r >= 0 && r < map.length && c >= 0 && c < map.length;
	}

}
