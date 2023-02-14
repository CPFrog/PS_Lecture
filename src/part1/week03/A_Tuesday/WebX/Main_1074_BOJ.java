package part1.week03.A_Tuesday.WebX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_BOJ {
	static int n, r, c, num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		getNumber(0, 0, n);
	}

	private static void getNumber(int startR, int startC, int size) {
		if (size == 2) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (startR + i == r && startC + j == c) {
						System.out.println(num);
					} else
						num++;
				}
			}
		} else {
			int newSize=size/2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (inRange(startR + newSize * i, startC + newSize * j, newSize)) {
						getNumber(startR + newSize * i, startC + newSize * j, newSize);
					}
					else num+=newSize*newSize;
				}
			}
		}
		return;
	}

	private static boolean inRange(int startR, int startC, int size) {
		return startR <= r && startR + size >= r && startC <= c && startC + size >= c;
	}

}
