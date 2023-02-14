package part1.week02.B_Tuesday.review;

public class SubsetTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) {
		visited = new boolean[n];
		subset(0, 0);
		System.out.println(cnt);
	}

	private static void subset(int count, int tot) {
		if (count == n) {
			cnt++;
			for (int i = 0; i < n; i++)
				if (visited[i])
					System.out.println(p[i] + " ");
			System.out.println("\n ----------------> " + tot);
			return;
		}
		visited[count] = true;
		subset(cnt + 1, tot + p[cnt]);
		visited[count] = false;
		subset(cnt + 1, tot);

	}

}
