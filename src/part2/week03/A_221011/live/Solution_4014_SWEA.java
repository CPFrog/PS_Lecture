package part2.week03.A_221011.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_SWEA {
	static int n, x;
	static int[][] map, map2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			map2 = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
			}
			sb.append("#" + t + " " + process() + "\n");
		}
		System.out.print(sb.toString());
	}

	private static int process() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (makeRoad(map[i]))
				cnt++;
			if (makeRoad(map2[i]))
				cnt++;
		}
		return cnt;
	}

	private static boolean makeRoad(int[] road) {
		int beforeHeight = road[0], streak = 1;
		int j = 1;
		while (j < n) {
			if (beforeHeight == road[j]) { // 높이가 동일한 경우
				streak++;
				j++;
			} else if (beforeHeight + 1 == road[j]) { // 이전 높이보다 1 높음 : 오르막 경사로 설치 체크
				if (streak < x)
					return false; // x 길이 미만이면 활주로 건설 불가
				beforeHeight++;
				streak = 1;
				j++;
			} else if (beforeHeight - 1 == road[j]) { // 이전 높이보다 1 작은 경우
				int cnt = 0;
				for (int k = j; k < n; k++) {
					if (road[k] != beforeHeight - 1)
						return false;
					if (++cnt == x)
						break;
				}
				if (cnt < x)
					return false;
				beforeHeight--;
				j+=x;
				streak = 0;
			} else // 높이가 2 이상 차이나는 경우
				return false;
		}
		return true;
	}
}
