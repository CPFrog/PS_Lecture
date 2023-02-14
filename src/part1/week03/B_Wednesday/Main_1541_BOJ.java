package part1.week03.B_Wednesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1541_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		int sum = 0;
		int curNum = 0;
		int sw = 1;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '-') {
				sum += curNum * sw;
				sw = -1;
				curNum = 0;
			} else if (line.charAt(i) == '+') {
				sum += curNum * sw;
				curNum = 0;
			} else {
				curNum *= 10;
				curNum += line.charAt(i) - '0';
			}
		}
		System.out.println(sum + (curNum * sw));
	}
}
