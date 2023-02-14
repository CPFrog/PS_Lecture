package part1.week01.A_Monday.WebX;

import java.util.Arrays;

// nPr
// ex. 5P3= 5*4*3
public class PermTest {
	static int[] p = { 1, 2, 3, 4 };
	static int n;
	static int r;
	static int[] nums; // 5P3 이면 3개 저장
	static boolean[] visited; // 사용한 적 있는지
	static int count;// 몇개의 nPr 개수 나오는지

	public static void main(String[] args) {
		n = p.length;
		r = 3;
		nums = new int[r];
		visited = new boolean[n];

		npr(0);
		System.out.println(count);
	}

	private static void npr(int cnt) {
		if (cnt == r) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			nums[cnt] = p[i];
			npr(cnt + 1);
			visited[i] = false;
		}
	}
}
