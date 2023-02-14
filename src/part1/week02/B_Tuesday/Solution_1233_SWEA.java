package part1.week02.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1233_SWEA {
	static String[] tree;
	static Stack<String> s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			s = new Stack<>();
			tree = new String[n + 1];
			StringTokenizer st;
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken();
			}
			int ans = postorder(1, n);
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int postorder(int i, int n) {
		int ans = 1;
		if (i * 2 < n) {
			ans = postorder(i * 2, n);
			if (ans == 0)
				return 0;
			ans = postorder(i * 2 + 1, n);
			if (ans == 0)
				return 0;
		}
		if (isOperator(tree[i])) {
			if (s.size() < 2)
				return 0;
			else {
				s.pop();
				s.pop();
				s.push("1");
			}
		} else
			s.push(tree[i]);
		return 1;
	}

	private static boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}
}
