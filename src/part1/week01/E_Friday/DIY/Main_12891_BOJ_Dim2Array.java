package part1.week01.E_Friday.DIY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12891_BOJ_Dim2Array {
	static int[][] hand; // row: String에서의 n번째 위치 || column: 0 → A, 1 → C, 2 → G, 3 → T
	static int[] needs; // 0 → A, 1 → C, 2 → G, 3 → T

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		hand = new int[p + 1][4];
		needs = new int[4];
		String input = br.readLine();
		char[] cArr = input.toCharArray();
		for (int i = 1; i <= p; i++) {
//			hand[i] = Arrays.copyOf(hand[i - 1], 4); --> 이 방법으로 간단하게 이전 위치의 누적 문자 개수를 복사해올 수는 있지만 훨씬 느리고 무겁습니다.
			hand[i][0] = hand[i - 1][0];
			hand[i][1] = hand[i - 1][1];
			hand[i][2] = hand[i - 1][2];
			hand[i][3] = hand[i - 1][3];
			switch (cArr[i - 1]) {
			case 'A':
				hand[i][0]++;
				break;
			case 'C':
				hand[i][1]++;
				break;
			case 'G':
				hand[i][2]++;
				break;
			case 'T':
				hand[i][3]++;
				break;
			}
		}
		int cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			needs[i] = Integer.parseInt(st.nextToken());
		for (int i = s; i <= p; i++)
			if (isValid(i - s, i))
				cnt++;

		System.out.println(cnt);
	}

	// 2차원 배열의 장점을 이용해 반복문으로 문자의 최소개수 조건을 만족하는지 여부를 판단할 수 있지만,
	// 반복문의 특성상 1차원 배열에서의 풀이처럼 빠른 비교는 불가능합니다.
	private static boolean isValid(int start, int end) {
		for (int i = 0; i < 4; i++) {
			if (hand[end][i] - hand[start][i] < needs[i])
				return false;
		}
		return true;
	}
}
