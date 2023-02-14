package DIY.problemSolve;

import java.io.*;
import java.util.*;

public class Main_1002_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			int dx = x2 - x1;
			int dy = y2 - y1;

			int ans;
			if (dx == 0 && dy == 0 && r1 == r2)
				ans = -1;
			else {
				int sumR = r1 + r2;
				int dr = r1 - r2;
				int sumRes = sumR * sumR - dx * dx - dy * dy;
				if (sumRes > 0) {
					int diffRes = dr * dr - dx * dx - dy * dy;
					if (diffRes > 0)
						ans = 0;
					else if (diffRes == 0)
						ans = 1;
					else
						ans = 2;
				} else if (sumRes == 0)
					ans = 1;
				else
					ans = 0;
			}

			sb.append(ans + "\n");
			T--;
		}
		System.out.println(sb.toString());
	}
}
