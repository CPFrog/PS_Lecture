package part2.week03.A_221011.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// KMP 알고리즘(Knuth–Morris–Pratt Algorithm) 
// O(N+M)
/**
 * @author taeheekim
 */
public class String_KMPTest {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();

		int tLength = text.length, pLength = pattern.length;

		// 부분일치테이블 만들기 : KMP의 아이디어를 똑같이 적용, W에서 W를 찾는 듯한 행위를 해서...
		int[] pi = new int[pLength];
		for (int i = 1, j = 0; i < pLength; i++) {// i:접미사 포인터(i=1부터 시작: 우리는 부분일치테이블를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.),
												  // j:접두사 포인터
			// i번째 문자와 j번째 문자가 일치하지 않는 경우 j를 j-1번째 패턴인덱스의 값으로 바꾸고, j가 0 이하가 되거나 문자가 일치할 때까지 무한 반복시킴.
			while (j > 0 && pattern[i] != pattern[j])
				j = pi[j - 1];

			// 현재 위치에서 올 수 있는 j의 값: 0 또는 i번째 문자와 일치하는 (뒤에서부터의 최초) 인덱스 값
			
			if (pattern[i] == pattern[j])// 만약 i번째 문자와 j번째 문자가 일치하는 경우
				pi[i] = ++j; // 돌아갈 위치를 j+1번째 인덱스로 지정하고 j를 1 증가시킴.
			
			else // 다를 경우
				pi[i] = 0; // 더이상 돌아갈 위치가 없으므로 (이미 위에서 j==0 상태일 것
		}

		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터 , j: 패턴 포인터
		for (int i = 0, j = 0; i < tLength; ++i) {

			while (j > 0 && text[i] != pattern[j])
				j = pi[j - 1];

			if (text[i] == pattern[j]) { // 두 글자 일치
				if (j == pLength - 1) { // j가 패턴의 마지막 인덱스라면
					cnt++; // 카운트 증가
					list.add(i - j);
					j = pi[j];
				} else {
					j++;
				}
			}
		}

		System.out.println(cnt);
		if (cnt > 0) {
			System.out.println(list);
		}
	}
}