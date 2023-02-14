package part1.week01.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_loop {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] boxs = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++)
				boxs[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(boxs);
			System.out.println(Arrays.toString(boxs));

			int front = 0, back = 99, fp = 0, bp = 99;
			while (n > 0) {
				if (fp == 0) {
					if (boxs[front + 1] == boxs[front])
						front++;
				}
				if(boxs[fp]==boxs[fp+1])
					fp--;
					

			}
			System.out.println("#" + t + " " + (boxs[back] - boxs[front]));

		}

	}

}
