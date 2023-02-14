package part1.week02.E_Friday;

import java.io.*;
import java.util.*;

public class Solution_4012_SWEA {
	static int[] mask;
	static int[][] synergy;
	static int size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			size = Integer.parseInt(br.readLine());
			mask = new int[size];
			synergy = new int[size][size];
			for (int i = 0; i < size; i++) {
				if (i < size / 2)
					mask[i] = 0;
				else
					mask[i] = 1;
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++)
					synergy[i][j] = Integer.parseInt(st.nextToken());
			}
			int minDiff = Integer.MAX_VALUE;
			do {
				int curDiff = getDiff();
				if (minDiff > curDiff)
					minDiff = curDiff;
			} while (np(size - 1));
			sb.append("#" + t + " " + minDiff + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int getDiff() {
		int teamA = 0, teamB = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (i == j)
					continue;
				if (mask[i] == mask[j]) {
					if (mask[i] == 0)
						teamA += synergy[i][j] + synergy[j][i];
					else
						teamB += synergy[i][j] + synergy[j][i];

				}
			}
		}

		return Math.abs(teamB - teamA);
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && mask[i - 1] >= mask[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (mask[i - 1] >= mask[j])
			j--;
		swap(i - 1, j);
		int k = size;
		while (i < k) {
			swap(i, k);
			i++;
			k--;
		}
		return true;
	}

	private static void swap(int i, int k) {
		int tmp = mask[i];
		mask[i] = mask[k];
		mask[k] = tmp;
	}
}
