package part1.week02.E_Friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15686_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		ArrayList<int[]> houses = new ArrayList<>();
		ArrayList<int[]> chickens = new ArrayList<>();
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1)
					houses.add(new int[] { r, c });
				if (map[r][c] == 2)
					chickens.add(new int[] { r, c });
			}
		}
		int[][] distance = new int[chickens.size()][houses.size()];

		for (int i = 0; i < chickens.size(); i++)
			getDistance(chickens.get(i), i, houses, distance);

		int[] mask = new int[chickens.size()];
		for (int i = 0; i < m; i++) {
			mask[chickens.size() - 1 - i] = 1;
		}
		int minSum = Integer.MAX_VALUE;
		do {
			int sum = 0;
			int[] minDist = new int[houses.size()];
			Arrays.fill(minDist, Integer.MAX_VALUE);
			for (int i = 0; i < chickens.size(); i++) {
				if (mask[i] == 1) {
					for (int j = 0; j < houses.size(); j++) {
						if (minDist[j] > distance[i][j])
							minDist[j] = distance[i][j];
					}
				}
			}
			for (int i : minDist)
				sum += i;
			if (sum < minSum)
				minSum = sum;
		} while (np(chickens.size() - 1, mask));
		System.out.println(minSum);
	}

	private static boolean np(int size, int[] arr) {
		int i = size;
		while (i > 0 && arr[i - 1] >= arr[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (arr[i - 1] >= arr[j])
			j--;
		swap(arr, i - 1, j);
		int k = size;
		while (i < k) {
			swap(arr, i, k);
			i++;
			k--;
		}
		return true;
	}

	private static void swap(int[] arr, int i, int k) {
		int tmp = arr[i];
		arr[i] = arr[k];
		arr[k] = tmp;
	}

	private static void getDistance(int[] pos, int idx, ArrayList<int[]> houses, int[][] distance) {
		for (int i = 0; i < houses.size(); i++)
			distance[idx][i] = manhatanDist(pos, houses.get(i));
	}

	static int manhatanDist(int[] from, int[] to) {
		return Math.abs(to[0] - from[0]) + Math.abs(to[1] - from[1]);
	}
}
