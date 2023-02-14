package part1.week03.B_Wednesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5644_SWEA {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int[] ae, be;
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int[][] moves = new int[2][m + 1];
			ae=new int[m+1];
			be=new int[m+1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= m; j++)
					moves[i][j] = Integer.parseInt(st.nextToken());
			}

			ArrayList<Integer>[][] apList = new ArrayList[10][10];
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					apList[i][j] = new ArrayList<Integer>();

			int[] apInfo = new int[a];
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				int cpos = Integer.parseInt(st.nextToken()) - 1;
				int rpos = Integer.parseInt(st.nextToken()) - 1;
				int range = Integer.parseInt(st.nextToken());
				apInfo[i] = Integer.parseInt(st.nextToken());

				for (int dr = -range; dr <= range; dr++) {
					if (rpos + dr < 0 || rpos + dr >= 10)
						continue;
					for (int dc = range - Math.abs(dr); Math.abs(dr) + Math.abs(dc) <= range; dc--) {
						if (cpos + dc >= 0 && cpos + dc < 10)
							apList[rpos + dr][cpos + dc].add(i);
					}
				}
			}

			Point pA = new Point(0, 0);
			Point pB = new Point(9, 9);

			int totalsum = 0;
			for (int i = 0; i <= m; i++) {
				pA.move(moves[0][i]);
				pB.move(moves[1][i]);
				int alen = apList[pA.r][pA.c].size();
				int max = 0;
				int amax=0, bmax=0;
				if (alen > 0) {
					for (int apA : apList[pA.r][pA.c]) {
						for (int apB : apList[pB.r][pB.c]) {
							if (apA == apB && max < apInfo[apA]) {
								max = apInfo[apA];
								amax=max;
							}
							else if (apA != apB && max < apInfo[apA] + apInfo[apB]) {
								max = apInfo[apA] + apInfo[apB];
								amax=apInfo[apA];
								bmax= apInfo[apB];
							}
						}
						if (max < apInfo[apA]) {
							max = apInfo[apA];
							amax=max;
						}
					}
				} else {
					for (int apB : apList[pB.r][pB.c])
						if (max < apInfo[apB]) {
							max = apInfo[apB];
							bmax=max;
						}
				}
				ae[i]=amax;
				be[i]=bmax;
				totalsum += max;
			}
			System.out.println(Arrays.toString(ae)+"\n"+Arrays.toString(be));
			sb.append("#" + t + " " + totalsum + "\n");
		}
		System.out.print(sb.toString());
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public void move(int n) {
			switch (n) {
			case 1:
				r--;
				break;
			case 2:
				c++;
				break;
			case 3:
				r++;
				break;
			case 4:
				c--;
				break;
			default:
				break;
			}
		}
	}
}
