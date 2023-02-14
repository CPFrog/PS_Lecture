package part1.week01.E_Friday.DIY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_BOJ_Dim1Array {
	static int[] handA, handC, handG, handT; // 현재 위치까지 가지고 있는 각 문자의 개수
	static int needA, needC, needG, needT; // 비밀번호 조건

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		// 메모이제이션(memoization) 하기 위한 배열 선언
		handA = new int[p + 1];
		handC = new int[p + 1];
		handG = new int[p + 1];
		handT = new int[p + 1];
		
		String input = br.readLine();
		char[] cArr = input.toCharArray();
		
		// Dynamic Programming 방식으로 현재 인덱스 위치까지의 각 문자 개수를 메모해둡니다. 
		for (int i = 1; i <= cArr.length; i++) {
			handA[i] = handA[i - 1];
			handC[i] = handC[i - 1];
			handG[i] = handG[i - 1];
			handT[i] = handT[i - 1];
			switch (cArr[i - 1]) {
			case 'A':
				handA[i]++;
				break;
			case 'C':
				handC[i]++;
				break;
			case 'G':
				handG[i]++;
				break;
			case 'T':
				handT[i]++;
				break;
			}
		}
		int cnt = 0;

		st = new StringTokenizer(br.readLine());
		needA = Integer.parseInt(st.nextToken());
		needC = Integer.parseInt(st.nextToken());
		needG = Integer.parseInt(st.nextToken());
		needT = Integer.parseInt(st.nextToken());
		for (int i = s; i <= p; i++)
			if (isValid(i - s, i))
				cnt++;

		System.out.println(cnt);
	}

	private static boolean isValid(int start, int end) {
		return handA[end] - handA[start] >= needA && handC[end] - handC[start] >= needC &&
			   handG[end] - handG[start] >= needG && handT[end] - handT[start] >= needT;
	}

}
