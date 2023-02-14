package part1.week03.C_Thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_BOJ {
	static int r, c;

	static int[] dr = { -1, 0, 1 };
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (line[j] == 'x')
					visited[i][j] = true;
			}
		}
		for (int i = 0; i < r; i++) 
			dfs(i, 0, visited);
		
		System.out.println(cnt);

	}

	static boolean dfs(int row, int col, boolean[][] visited) {
		if (col + 1 == c) {
			cnt++;
			return true;
		}
		boolean available = false;
		for (int i = 0; i < 3 && !available; i++) {
			int nr = row + dr[i];
			if (nr >= 0 && nr < r) {
				if (!visited[nr][col + 1]) {
					visited[nr][col + 1] = true;
					available = dfs(nr, col + 1, visited);
				}
			}
		}
		return available;
	}
}
