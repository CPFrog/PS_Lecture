package part1.week02.C_Wednesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_4008_SWEA {
	static int[] operands;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> ar = new ArrayList<>(); // 숫자로 바뀐 연산자들이 들어가는 배열
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) { // 0 → +, 1 → -, 2 → * , 3 → /
				int tmp = Integer.parseInt(st.nextToken());
				while (--tmp >= 0)
					ar.add(i);
			}
			operands = new int[ar.size()];
			for (int i = 0; i < ar.size(); i++)
				operands[i] = ar.get(i);
			int maxRes = Integer.MIN_VALUE; // -21억
			int minRes = Integer.MAX_VALUE; // +21억
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			do {
				int res = arr[0];
				for (int i = 0; i < n - 1; i++)
					res = calc(res, arr[i + 1], operands[i]);
				if (res > maxRes)
					maxRes = res;
				if (res < minRes)
					minRes = res;
			} while (np(operands.length - 1));
			sb.append("#" + t + " " + (maxRes - minRes) + "\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && operands[i - 1] >= operands[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (operands[i - 1] >= operands[j])
			j--;
		int tmp = operands[i - 1];
		operands[i - 1] = operands[j];
		operands[j] = tmp;
		int k = size;
		while (i < k) {
			tmp = operands[i];
			operands[i++] = operands[k];
			operands[k--] = tmp;
		}

		return true;
	}

	static int calc(int a, int b, int op) { // a, b = 그냥 숫자, op - 연산자에 대응하는 숫자
		switch (op) {
		case 0: // + 연산
			return a + b;
		case 1: // - 연산
			return a - b;
		case 2: // * 연산
			return a * b;
		default: // 3 → / 연산
			return a / b;
		}
	}
}
