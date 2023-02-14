package part2.week02.C_221006.DIY;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_12015_BOJ {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/part2/week02/C_221006/SampleTC/BOJ_12015.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (arr.isEmpty() || arr.get(arr.size() - 1) < tmp) {
				arr.add(tmp);
			} else {
				int idx = binarySearch(arr, tmp, 0, arr.size() - 1);
				arr.set(idx, tmp);
			}
		}
		System.out.println(arr.size());
	}

	private static int binarySearch(ArrayList<Integer> arr, int target, int left, int right) {
		if (left >= right)
			return left;
		int mid = (left + right) / 2;
		if (arr.get(mid) < target)
			return binarySearch(arr, target, mid+1, right);
		else if (arr.get(mid) > target)
			return binarySearch(arr, target, left, mid);
		else
			return mid;
	}
}
