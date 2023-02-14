package DIY.problemSolve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_BOJ {
	static int r, c, minSwitch;
	static char[] color = { 'B', 'W' };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		char[][] board = new char[r][c];
		minSwitch = Integer.MAX_VALUE;
		for (int i = 0; i < r; i++)
			board[i] = br.readLine().toCharArray();
		for (int i = 0; i <= r - 8; i++) 
			for (int j = 0; j <= c - 8; j++) 
				makeBoard(board, i, j);
		System.out.println(minSwitch);
	}

	private static void makeBoard(char[][] board, int i, int j) {
		for (int idx = 0; idx < 2; idx++) {
			int cnt = 0;
			int sw = idx;
			for (int dr = 0; dr < 8 && cnt <= minSwitch; dr++) {
				for (int dc = 0; dc < 8; dc++) {
					if (board[i + dr][j + dc] != color[sw]) {
						cnt++;
						if (cnt > minSwitch)
							break;
					}
					sw = (sw == 0 ? 1 : 0);
				}
				sw = (sw == 0 ? 1 : 0);
			}
//			System.out.println(color[idx]+": "+cnt);
			if(minSwitch>cnt)
				minSwitch=cnt;
		}
	}

}
