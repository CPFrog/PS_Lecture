package part1.week01.E_Friday.DIY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_2819_SWEA {
	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };
	static int map[][];
	static int nums[];
	static Set<String> s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			nums = new int[7];
			s = new HashSet<>();
			map = new int[4][4];
			for (int r = 0; r < 4; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 4; c++)
					map[r][c] = Integer.parseInt(st.nextToken());
			}
			for (int sr = 0; sr < 4; sr++)
				for (int sc = 0; sc < 4; sc++)
					dfs(sr, sc, 0);
			System.out.println("#" + (t + 1) + " " + s.size());
		}

	}

	private static void dfs(int r, int c, int depth) {
		if (depth == 7) {
			StringBuilder sb = new StringBuilder("");
			for (int i : nums)
				sb.append(i);
//			System.out.println(sb.toString());
			s.add(sb.toString());
			return;
		}
		nums[depth] = map[r][c];

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isValid(nr, nc)) {
				dfs(nr, nc, depth + 1);
			}
		}
	}

	private static boolean isValid(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}
}
