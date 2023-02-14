package part1.week02.C_Wednesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_BOJ {
	static int[][] arr;
	static int[][] command;
	static int n,m,k;
	static int[] cwdr = { 0, 1, 0, -1 };
	static int[] cwdc = { 1, 0, -1, 0 };
	static int[] rcwdr = { 1, 0, -1, 0 };
	static int[] rcwdc = { 0, 1, 0, -1 };
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[k];
		command = new int[k][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				command[i][j] = Integer.parseInt(st.nextToken());
		}
		int ans = dfs(0);
		System.out.println(ans);
	}

	private static int dfs(int depth) {
		int ans=Integer.MAX_VALUE;
		if (depth == k) {
			
			return getMinRowSum();
			
		}
		for (int i = 0; i < k; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			int r = command[i][0]-1;
			int c = command[i][1]-1;
			int s = command[i][2];
			rotateCW(r - s, r + s, c - s, c + s);
			int returns = dfs(depth + 1);
			if (ans > returns)
				ans = returns;
			rotateRCW(r - s, r + s, c - s, c + s);
			visited[i] = false;
		}
		return ans;
	}

	private static void rotateRCW(int up, int down, int left, int right) {
		if (up >= down || left >= right)
			return;
		rotateRCW(up + 1, down - 1, left + 1, right - 1);
		int curR = up;
		int curC = left;
		int d = 0;
		boolean sw = true;
		int nextVal = arr[curR][curC];
		while (sw) {
			int nextR = curR + rcwdr[d];
			int nextC = curC + rcwdc[d];
			if (nextR < up || nextR > down || nextC < left || nextC > right) {
				d++;
				continue;
			}
			if (nextR == up && nextC == left)
				sw = false;
			int tmp = arr[nextR][nextC];
			arr[nextR][nextC] = nextVal;
			nextVal = tmp;
			curR = nextR;
			curC = nextC;
		}
	}

	private static void rotateCW(int up, int down, int left, int right) {
		if (up >= down || left >= right)
			return;
		rotateCW(up + 1, down - 1, left + 1, right - 1);
		int curR = up;
		int curC = left;
		int d = 0;
		boolean sw = true;
		int nextVal = arr[curR][curC];
		while (sw) {
			int nextR = curR + cwdr[d];
			int nextC = curC + cwdc[d];
			if (nextR < up || nextR > down || nextC < left || nextC > right) {
				d++;
				continue;
			}
			if (nextR == up && nextC == left)
				sw = false;
			int tmp = arr[nextR][nextC];
			arr[nextR][nextC] = nextVal;
			nextVal = tmp;
			curR = nextR;
			curC = nextC;
		}
	}

	private static int getMinRowSum() {
		int curMin = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr[i].length; j++)
				sum += arr[i][j];
			if (curMin > sum)
				curMin = sum;
		}
		return curMin;
	}
}
