package DIY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14695_SWEA {
	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			Point base = new Point(st.nextToken(), st.nextToken(), st.nextToken());

			int cnt = 1;
			boolean flag = true;
			Point prevP = new Point();
			Vector prevV = new Vector(1, 1, 1);

			for (int j = 1; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				if (flag) {
					Point newSpider = new Point(st.nextToken(), st.nextToken(), st.nextToken());
					Vector target = getNormalVector(base, prevP, newSpider);
					if (cnt > 2 && !isParallel(prevV, target))
						flag = false; // 입력은 받아야하므로 break 쓰면 안됨.

					prevV = target; // 제대로 동작 안하면 clone으로 복사.
					prevP = newSpider;
					if (flag)
						cnt++;
				}
			}
			sb.append("#" + t + " " + (cnt == n ? "TAK" : "NIE") + "\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean isParallel(Vector prevV, Vector target) {
		boolean divByZero = false;
		double base = 0;
		if (prevV.x == 0)
			divByZero = true;
		else
			base = (double) target.x / prevV.x;
		if (prevV.y == 0) {
			if (!divByZero)
				return false;
		} else {
			if (base != (double) target.y / prevV.y)
				return false;
		}
		if (prevV.z == 0) {
			if (!divByZero)
				return false;
		} else {
			if (base != (double) target.z / prevV.z)
				return false;
		}
		return true;
	}

	private static Vector getNormalVector(Point base, Point prevP, Point newSpider) {
		long x1 = prevP.x - base.x;
		long y1 = prevP.y - base.y;
		long z1 = prevP.z - base.z;
		long x2 = newSpider.x - base.x;
		long y2 = newSpider.y - base.y;
		long z2 = newSpider.z - base.z;
		long nx = y1 * z2 - z1 * y2;
		long ny = x1 * z2 - z1 * x2;
		long nz = x1 * y2 - y1 * x2;

		long div = gcd(gcd(nx, ny), nz);
		System.out.println(div);

		if (div == 0)
			div = 1;
		return new Vector(nx / div, -ny / div, nz / div);
	}

	private static long gcd(long a, long b) {
		if (a < b)
			return gcd(b, a);
		if (b > 0)
			return gcd(b, b % a);
		return a;
	}

	static class Vector {
		long x, y, z;

		public Vector() {
		}

		public Vector(long x, long y, long z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class Point {
		long x, y, z;

		public Point() {
		}

		public Point(String x, String y, String z) {
			this.x = Long.parseLong(x);
			this.y = Long.parseLong(y);
			this.z = Long.parseLong(z);
		}
	}
}
