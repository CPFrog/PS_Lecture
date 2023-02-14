package part1.week01.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_SWE {
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

			int poorDiff = 0;
			int RichDiff = 0;
			int front = 0;
			int back = 99;
			while (n > 0) {
//				System.out.println(front+" "+back);
				if (poorDiff == 0) {
					while (boxs[front + 1] <= boxs[front])
						front++;
					int frontPrev = boxs[front];
					int tmp = boxs[front + 1] - frontPrev;
					poorDiff = tmp * (front + 1);
				}

				if (RichDiff == 0) {
					while (boxs[back - 1] >= boxs[back]) {
//						System.out.print(back+" ");
						back--;
					}
					int backPrev = boxs[back];
					int tmp = backPrev - boxs[back - 1];
					RichDiff = tmp * (100 - back);
				}
				if (poorDiff < RichDiff) {
					Arrays.fill(boxs, 0, front, boxs[front + 1]);
					RichDiff -= poorDiff;
					n -= poorDiff;
					poorDiff = 0;

				} else if (poorDiff > RichDiff) {
					Arrays.fill(boxs, back, 99, boxs[back - 1]);
					poorDiff -= RichDiff;
					n -= RichDiff;
					RichDiff = 0;
				} else {
					Arrays.fill(boxs, back, 99, boxs[back - 1]);
					Arrays.fill(boxs, 0, front, boxs[front + 1]);
					n -= RichDiff;
					RichDiff = 0;
					poorDiff = 0;
				}
			}
			int fp = 0;
			int bp = 99;
			for (; n >= 0; n++) {
				boxs[fp++]--;
				boxs[bp--]++;
				if (fp == front)
					fp = 0;
				if (bp == back)
					bp = 99;
			}
			System.out.println("#" + t + " " + (boxs[back] - boxs[front]));

//			while (n > 0) {
//				int richDiff = boxs[back] - boxs[back - 1];
//				richDiff *= (100 - back);
//				
//				if (richDiff > n) {
//					int poorDiff = boxs[front + 1] - boxs[front];
//					if (poorDiff >= richDiff) {
//						boxs[front] += richDiff;
//						n -= richDiff;
//					} else {
//						richDiff-=poorDiff;
//						
//					}
//				}
//
//			}
		}

	}

}
