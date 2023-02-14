package part1.week04.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());

		int[][] box = new int[row][col];
		Queue<Point> q = new LinkedList<>(); // 오늘 익을 토마토들 위치 저장되는 큐
		// 토마토 상자 초기 상태 입력받음.
		int tomatoes = 0; // 토마토가 다 익었는지 여부를 확인하기 위해 익어야하는 토마토 개수 저장해두는 변수.
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 0)
					tomatoes++;
				else if (box[i][j] == 1)
					q.offer(new Point(i, j));
			}
		}

		Queue<Point> nextQ = new LinkedList<>(); // 다음날 익을 토마토들 위치 저장되는 큐
		int day = 0;
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		boolean hasChanged = false; // 상자가 다 익은상태일 수도 있다. 이 경우 days 변수를 증가시키면 안되므로, 익은 토마토가 있는지 여부를 체크하는 변수가 필요.
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.row + dr[i];
				int nc = p.col + dc[i];
				if (nr >= 0 && nr < row && nc >= 0 && nc < col && box[nr][nc] == 0) {
					box[nr][nc] = 1; // 상자의 값이 1이라면 익은 상태이다. 다시 말해, 더이상 방문할 필요가 없는 상태이므로 visited의 역할까지 수행 가능.
					tomatoes--;
					nextQ.add(new Point(nr, nc));
					hasChanged = true;
				}
			}
			if (q.isEmpty() && hasChanged) {
				q.addAll(nextQ);
				nextQ = new LinkedList<>();
				hasChanged = false;
				day++;
			}
		}
		System.out.println(tomatoes==0?day:-1);
	}

	static class Point {
		int row, col;

		public Point(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}

}
