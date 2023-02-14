package part1.week03.D_Friday;

import java.io.*;
import java.util.*;

public class Main_17135_BOJ {
	static int r, c, d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		int[][] map = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int maxEnemies = 0;
		for (int i = 0; i < c - 2; i++) {
			for (int j = i + 1; j < c - 1; j++) {
				for (int k = j + 1; k < c; k++) {

					int tmp = simulation(new int[] { i, j, k }, arrCpy(map));
					if (maxEnemies < tmp)
						maxEnemies = tmp;
				}
			}
		}
		System.out.println(maxEnemies);
	}

	static int[][] arrCpy(int[][] arr) {
		int[][] newarr = new int[r][c];
		for (int i = 0; i < r; i++)
			newarr[i] = Arrays.copyOf(arr[i], c);
		return newarr;
	}

	public static int simulation(int[] archers, int[][] map) {
		int killed = 0;
		for (int t = 0; t < r; t++) {
			TreeSet<Point> set = new TreeSet<>();
			for (int archerPos : archers) {
				boolean hasFound = false;
				int minDist = d + t + 1;
				Point minPos = new Point(-1, -1);
				for (int row = r - 1 - t; row >= 0; row--) {
					for (int col = 0; col < c; col++) {
						Point tmpPos = new Point(row, col);
						int tmp = getDistance(tmpPos, new Point(r, archerPos));
						if (map[row][col] == 1) {
							if (minDist > tmp) {
								hasFound = true;
								minPos = tmpPos;
								minDist = tmp;
							} else if (minDist == tmp) {
								if (minPos.col > tmpPos.col)
									minPos = tmpPos;
							}

						}
					}
				}
				if (hasFound)
					set.add(minPos);

			}
			for (Point p : set)
				map[p.row][p.col] = 0;

			killed += set.size();
		}
		return killed;
	}

	static int getDistance(Point from, Point to) {
		return Math.abs(from.row - to.row) + Math.abs(from.col - to.col);
	}

	static class Point implements Comparable<Point> {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public int compareTo(Point o) {
			return this.row != o.row ? this.row - o.row : this.col - o.col;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point tmp = (Point) obj;
				return this.row == tmp.row && this.col == tmp.col;
			}
			return false;
		}
	}
}
