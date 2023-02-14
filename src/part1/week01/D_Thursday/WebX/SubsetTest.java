package part1.week01.D_Thursday.WebX;

public class SubsetTest {
	static int[] p = { 1, 2, 3, 4, 5 };
	static int n = p.length;
	static int r;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) {
		r = 3;
		visited = new boolean[n];
		npr(0);
		System.out.println(count);
	}

	private static void npr(int step) {
		if (step == n) {
			for (int i = 0; i < n; i++) {
				if (visited[i])
					System.out.print(p[i] + " ");
			}
			System.out.println();
			count++;
			return;
		}
		visited[step] = true;
		npr(step + 1);
		visited[step] = false;
		npr(step + 1);
	}
}