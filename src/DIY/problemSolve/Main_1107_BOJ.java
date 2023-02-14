package DIY.problemSolve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int goal = Integer.parseInt(br.readLine());
		int brokeN = Integer.parseInt(br.readLine());
		boolean[] isBroken = new boolean[10];
		if (brokeN > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < brokeN; i++)
				isBroken[Integer.parseInt(st.nextToken())] = true;
		}
		int ans = Math.abs(goal - 100);
		int minpoint=-1;
		for (int i = 0; i < 1000000; i++) {
			int t = i;
			boolean hasFinished=true;
			int curAns = Math.abs(goal - i);
			do {
				if (isBroken[t % 10]) {
					hasFinished=false;
					break;
				}
				t /= 10;
				
				curAns++;
			} while (t > 0);
			if (t == 0 && hasFinished) {
				if (curAns < ans) {
					ans = curAns;
					minpoint=i;
				}
			}
		}
		System.out.println(ans);
	}
}
