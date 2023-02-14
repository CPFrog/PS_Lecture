package part2.week02.B_221005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Pair_17143 {
	static int R, C, M, total;

	static class Shark {
		int r, c;
		int s, d, z;
		boolean live;

		public Shark(int r, int c, int s, int d, int z, boolean live) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.live = live;
		}
	}

	static Shark[][] map;
	static List<Shark> sharks = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R][C];
		total = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(r, c, s, d, z, true);
			sharks.add(shark);

			// 맵에 상어 표시
			map[r][c] = shark;
		}
		fishing();
		System.out.println(total);
	}

	private static void fishing() {
		for (int loc = 0; loc < C; loc++) {
			// 낚시왕 이동
			System.out.println("phase "+(loc+1));
			for (int i = 0; i < sharks.size(); i++) {
				if (sharks.get(i).live)
					System.out.println("(" + (sharks.get(i).r+1) + ", " + (sharks.get(i).c+1) + "), size: " + sharks.get(i).z);
			}

			// 상어 낚시
			for (int i = 0; i < R; i++) {
				if (map[i][loc] != null) {
					// 리스트에 있던 상어 삭제
					for (int j = 0; j < sharks.size(); j++) {
						if (sharks.get(j).live && sharks.get(j) == map[i][loc]) {
							sharks.get(j).live = false;
							break;
						}
					}
					total += map[i][loc].z;
					map[i][loc] = null;
					break;
				}
			}
			// 상어 이동
			for (int i = 0; i < sharks.size(); i++) {
				if (sharks.get(i).live) {
					Shark s = sharks.get(i);
					map[s.r][s.c] = null;
					int r = R - 1;
					int c = C - 1;
					if (s.d == 1) { // 위
						int nr = 0;
						if (s.r == 0) {
							s.d = 2;
							nr = s.r + 1 * s.s;
						} else
							nr = s.r - 1 * s.s;
						while (nr < 0 || nr > R - 1) {
							if (nr < 0) {
								s.d = 2;
								nr = (nr * -1);
							}
							if (nr > R - 1) {
								s.d = 1;
								nr = r - (nr - r);
							}
						}
						s.r = nr;
					} else if (s.d == 2) { // 아래
						int nr = 0;
						if (s.r == R - 1) {
							s.d = 1;
							nr = s.r - 1 * s.s;
						} else
							nr = s.r + 1 * s.s;

						while (nr < 0 || nr > R - 1) {
							if (nr > R - 1) {
								s.d = 1;
								nr = r - (nr - r);
							}
							if (nr < 0) {
								s.d = 2;
								nr = (nr * -1);
							}
						}
						s.r = nr;
					} else if (s.d == 3) { // 오른쪽
						int nc = 0;
						if (s.c == C - 1) {
							s.d = 4;
							nc = s.c - 1 * s.s;
						} else
							nc = s.c + 1 * s.s;

						while (nc < 0 || nc > C - 1) {
							if (nc > C - 1) {
								s.d = 4;
								nc = c - (nc - c);
							}
							if (nc < 0) {
								s.d = 3;
								nc = (nc * -1);
							}
						}
						s.c = nc;
					} else if (s.d == 4) { // 왼쪽
						int nc = 0;
						if (s.c == 0) {
							s.d = 3;
							nc = s.c + 1 * s.s;
						} else
							nc = s.c - 1 * s.s;
						while (nc < 0 || nc > C - 1) {
							if (nc < 0) {
								s.d = 3;
								nc = (nc * -1);
							}
							if (nc > C - 1) {
								s.d = 4;
								nc = c - (nc - c);
							}
						}
						s.c = nc;
					}
					if (map[s.r][s.c] != null) { // 해당 자리에 상어가 있음
						Shark cmp = map[s.r][s.c]; // 사이즈 비교 상어
						if (cmp.z > s.z) {
							s.live = false;
						} else {
							map[s.r][s.c].live = false;
							map[s.r][s.c] = s;
						}
					} else {
						map[s.r][s.c] = s;
					}
				}
			}
		}
	}

}