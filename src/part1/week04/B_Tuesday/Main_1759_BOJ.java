package part1.week04.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		char[] set = new char[c];
		int[] p = new int[c];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			set[i] = st.nextToken().charAt(0);
			if (i < l)
				p[i] = 1;
		}
		Arrays.sort(set);

		boolean isAEIOU[] = new boolean[c];
		for (int i = 0; i < c; i++)
			if (set[i] == 'a' || set[i] == 'e' || set[i] == 'i' || set[i] == 'o' || set[i] == 'u')
				isAEIOU[i] = true;

		StringBuilder sb = new StringBuilder();
		do {
			StringBuilder tmp = new StringBuilder();
			int cnt = 0, mo = 0;
			for (int i = 0; i < c; i++) {
				if (p[i] == 1) {
					cnt++;
					if (isAEIOU[i])
						mo++;
					tmp.append(set[i]);
					if (cnt == l)
						break;
				}
			}
			if (mo > 0 && cnt - mo > 1)
				sb.append(tmp.toString() + "\n");
		} while (prevPerm(p));

		System.out.print(sb.toString());
	}

	private static boolean prevPerm(int[] p) {
		int size = p.length - 1;
		int i = size, j = size, k = size;
		while (i > 0 && p[i - 1] <= p[i])
			i--;
		if (i == 0)
			return false;
		while (p[i - 1] <= p[j])
			j--;
		swap(p, i - 1, j);
		while (i < k)
			swap(p, i++, k--);
		return true;
	}

	private static void swap(int[] p, int i, int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
}
