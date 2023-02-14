package part1.week02.A_Monday.live;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_7568_Comparator {
	static int n;

	static class Person implements Comparable<Person> {
		int x, y;

		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Person p) {
			int rx = Integer.compare(this.x, p.x);
			int ry = Integer.compare(this.y, p.y);
			if (rx > 0 && ry > 0)
				return -1; // 앞에 있는 것이 크다면 순위 상승
			else if (rx < 0 && ry < 0)
				return 1;// 앞에 있는 것이 작다면 순위 하락
			else
				return 0; // 아니라면 우열 가릴 수 없으므로 순위 유지
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		List<Person> origin = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Person tmp = new Person(sc.nextInt(), sc.nextInt());
			origin.add(tmp);
		}
		int rank[]=new int[n];
		Collections.sort(origin);
		System.out.println(origin.toString());
	}

}
