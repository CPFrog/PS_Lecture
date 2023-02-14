package part1.week03.C_Thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_SWEA_NextPerm {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t = 1; t <= T; t++) {

			int n = Integer.parseInt(br.readLine());
			Point[] pArr = new Point[n];
			int[] npArr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point office = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < n; i++) {
				pArr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				npArr[i] = i;
			}
			int minDist = Integer.MAX_VALUE;
			do {
				int curDist = getTotalDistance(home, office, pArr, npArr);
				if (minDist > curDist)
					minDist = curDist;
			} while (np(n - 1, npArr));
			
			sb.append("#"+t+" "+minDist+"\n");
		}
		System.out.print(sb.toString());

	}

	private static boolean np(int size, int[] arr) {
		int i = size;
		while (i > 0 && arr[i - 1] > arr[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (arr[i - 1] > arr[j])
			j--;
		swap(i - 1, j, arr);
		int k = size;
		while (i < k)
			swap(i++, k--, arr);
		return true;
	}

	private static void swap(int i, int j, int[] arr) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	static int getTotalDistance(Point home, Point office, Point[] pArr, int[] npArr) {
		int sum = getDistance(office, pArr[npArr[0]]);
		for (int i = 1; i < npArr.length; i++) {
			sum += getDistance(pArr[npArr[i - 1]], pArr[npArr[i]]);
		}
		return sum + getDistance(pArr[npArr[npArr.length - 1]], home);
	}

	static int getDistance(Point from, Point to) {
		return Math.abs(from.r - to.r) + Math.abs(from.c - to.c);
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
