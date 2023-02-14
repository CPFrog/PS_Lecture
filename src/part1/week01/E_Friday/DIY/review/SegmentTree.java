package part1.week01.E_Friday.DIY.review;

import java.io.*;
import java.util.StringTokenizer;

public class SegmentTree {
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		m += Integer.parseInt(st.nextToken());
		arr = new long[n];
		tree = new long[n * 4];
		for (int i = 0; i < n; i++)
			arr[i] = Long.parseLong(br.readLine());
		init(0, n - 1, 1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int option = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			switch (option) {
			case 1:
				update(0, arr.length - 1, 1, a - 1, b - arr[a - 1]);
				arr[a - 1] = b;
				break;
			case 2:
				bw.append(sum(0, arr.length - 1, 1, a - 1, b - 1) + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static long init(int start, int end, int node) {
		if (start == end)
			return tree[node] = arr[start];
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

	private static long sum(int start, int end, int node, int left, long right) {
		if (left > end || right < start)
			return 0;
		if (left <= start && end <= right)
			return tree[node];
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	private static void update(int start, int end, int node, int idx, long diff) {

		if (idx < start || end < idx)
			return;
		tree[node] += diff;
		if (start == end)
			return;
		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, diff);
		update(mid + 1, end, node * 2 + 1, idx, diff);
	}
}
