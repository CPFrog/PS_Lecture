package DIY.problemSolve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11505_BOJ {
	static final int DIV = 1000000007;
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[n+1];
		long[] tree = new long[n * 4];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		init(arr, tree, 0, n - 1, 1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				update(arr, tree, 0, n - 1, b-1, c, 1);
				arr[b-1]=c;
//				System.out.println(Arrays.toString(tree));
			} else {
				sb.append(get(tree, 0, n - 1, b-1, c-1, 1)+"\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static long get(long[] tree, int start, int end, int leftLimit, int rightLimit, int node) {
		if (leftLimit > end || rightLimit < start)
			return 1;
		if (leftLimit<=start && end<=rightLimit)
			return tree[node];
		int mid = (start + end) / 2;
		return (get(tree, start, mid, leftLimit, rightLimit, node * 2)
				* get(tree, mid + 1, end, leftLimit, rightLimit, node * 2 + 1))%DIV;
	}

	private static void update(int[] arr, long[] tree, int start, int end, int idx, int newVal, int node) {
		if (start > idx || end <idx)
			return;
//		System.out.println("before "+node+" : "+tree[node]);
		tree[node] = ((tree[node] * newVal)/arr[idx]) % DIV;
//		System.out.println("after "+node+" : "+tree[node]);
		if (start == end)
			return;
		int mid = (start + end) / 2;
		update(arr, tree, start, mid, idx, newVal, node * 2);
		update(arr, tree, mid + 1, end, idx, newVal, node * 2 + 1);
	}

	private static long init(int[] arr, long[] tree, int start, int end, int node) {
		if (start == end)
			return tree[node] = arr[start];
		int mid = (start + end) / 2;
		return tree[node] = (init(arr, tree, start, mid, node * 2) * init(arr, tree, mid + 1, end, node * 2 + 1)) % DIV;

	}

}
