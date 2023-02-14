package part2.week02.B_221005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17143_BOJ {
	static int rows, cols, sharkNum;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());
		sharkNum = Integer.parseInt(st.nextToken());

		ArrayList<Shark> sharks = new ArrayList<>();
		for (int i = 0; i < sharkNum; i++) {
			st = new StringTokenizer(br.readLine());
			Shark tmp = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
			sharks.add(tmp);
		}

		int ans = 0;
		Collections.sort(sharks);
		// 1. 낚시꾼이 이동함
		for (int i = 1; i <= cols; i++) {
			System.out.println("phase " + i);
			for (Shark s : sharks)
				System.out.println(s);
			// 2. 가장 가까운 상어 낚음
			for (int idx = 0; idx < sharks.size(); idx++) {
				Shark tmp = sharks.get(idx);
				if (tmp.c == i) {
					ans += tmp.size;
					System.out.println("현재 몸무게 : "+ans);
					sharks.remove(idx);
					break;
				} else if (tmp.c > i)
					break;
			}

			// 3. 상어끼리 이동함
			sharks = moveSharks(sharks);
		}
		System.out.println(ans);
	}

	private static ArrayList<Shark> moveSharks(ArrayList<Shark> sharks) {
		Shark[][] map = new Shark[rows + 1][cols + 1];
		for (Shark s : sharks) {
			Shark tmp = s;
			// 0 위, 1 아래, 2 오른쪽, 3 왼쪽
			int moves = 0;
			if (s.head <= 1) {
				int mod = (rows - 1) * 2;
				moves = s.speed % mod;

			} else {
				int mod = (cols - 1) * 2;
				moves = s.speed % mod;
			}

			for (int i = 0; i < moves; i++) {
				int nr = s.r + dr[s.head];
				int nc = s.c + dc[s.head];

				if (nr < 1 || nr > rows) {
					if (s.head == 0)
						s.head = 1;
					else if (s.head == 1)
						s.head = 0;
					nr = s.r + dr[s.head];
					nc = s.c + dc[s.head];
				}
				if (nc < 1 || nc > cols) {
					if (s.head == 2)
						s.head = 3;
					else if (s.head == 3)
						s.head = 2;
					nr = s.r + dr[s.head];
					nc = s.c + dc[s.head];
				}
				s.r = nr;
				s.c = nc;
			}

			if (map[s.r][s.c] != null) {
				if (map[s.r][s.c].size < s.size)
					map[s.r][s.c] = s;
			} else
				map[s.r][s.c] = s;
		}

		ArrayList<Shark> ret = new ArrayList<>();
		for (int c = 1; c <= cols; c++) {
			for (int r = 1; r <= rows; r++) {
				if (map[r][c] != null)
					ret.add(map[r][c]);
			}
		}
		return ret;
	}

	static class Shark implements Comparable<Shark> {
		int r, c, speed, head, size;

		public Shark(int r, int c, int speed, int head, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.head = head;
			this.size = size;
		}

		@Override
		public String toString() {
			return "(" + r + ", " + c + ") size=" + size;
		}

		@Override
		public int compareTo(Shark o) {
			return this.c != o.c ? this.c - o.c : (this.r != o.r ? this.r - o.r : o.size - this.size);
		}

	}

	static boolean rangeCheck(int r, int c) {
		return r >= 1 && r <= rows && c >= 1 && c <= cols;
	}
}
