package part1.week01.E_Friday.DIY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10868_BOJ {
	static long[] tree;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new long[n];
		tree = new long[n * 4];

		for (int i = 0; i < n; i++)
			arr[i] = Long.parseLong(br.readLine());
		init(0, n - 1, 1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.append(getMin(0, n - 1, 1, a - 1, b - 1) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static long init(int start, int end, int node) {
		if (start == end)
			return tree[node] = arr[start];
		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}

	private static long getMin(int start, int end, int node, int left, int right) {
		if (start > right || end < left)
			return Integer.MAX_VALUE;
		if (left <= start && end <= right)
			return tree[node];
		int mid = (start + end) / 2;
		return Math.min(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right));
	}
}
