package DIY.problemSolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2357_BOJ {
	static int arr[];
	static int minTree[];
	static int maxTree[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		minTree = new int[n * 4];
		maxTree = new int[n * 4];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		minInit(0, n - 1, 1);
		maxInit(0, n - 1, 1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			bw.append(getMin(0, n - 1, 1, left-1, right-1) + " " + getMax(0, n - 1, 1, left-1, right-1) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int minInit(int start, int end, int node) {
		if (start == end)
			return minTree[node] = arr[start];
		int mid = (start + end) / 2;
		return minTree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
	}

	private static int getMin(int start, int end, int node, int left, int right) {
		if (left > end || right < start)
			return Integer.MAX_VALUE;
		if (left <= start && end <= right)
			return minTree[node];
		int mid = (start + end) / 2;
		return Math.min(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right));
	}

	private static int maxInit(int start, int end, int node) {
		if (start == end)
			return maxTree[node] = arr[start];
		int mid = (start + end) / 2;
		return maxTree[node] = Math.max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
	}

	private static int getMax(int start, int end, int node, int left, int right) {
		if (left > end || right < start)
			return Integer.MIN_VALUE;
		if (left <= start && end <= right)
			return maxTree[node];
		int mid = (start + end) / 2;
		return Math.max(getMax(start, mid, node * 2, left, right), getMax(mid + 1, end, node * 2 + 1, left, right));
	}
}
