package part2.week03.A_221011.DIY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1786_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		int[] pi = new int[pattern.length];

		for (int i = 1, j = 0; i < pattern.length; i++) {
			while (j > 0 && pattern[i] != pattern[j])
				j = pi[j - 1];

			if (pattern[i] == pattern[j])
				pi[i] = ++j;
			else
				pi[i] = 0;
		}

		ArrayList<Integer> idxList = new ArrayList<>();

		for (int i = 0, j = 0; i < text.length; i++) {
			while (j > 0 && text[i] != pattern[j])
				j = pi[j - 1];

			if (text[i] == pattern[j]) {
				if (j == pattern.length - 1) {
					idxList.add(i - j);
					i -= (j - 1);
					j = 0;
				} else
					j++;
			}
		}
		sb.append(idxList.size() + "\n");
		if (idxList.size() > 0)
			for (int i : idxList)
				sb.append(Integer.toString(i + 1) + " ");

		System.out.println(sb.toString());
	}
}
