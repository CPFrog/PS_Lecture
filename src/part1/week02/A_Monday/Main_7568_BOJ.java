package part1.week02.A_Monday;

import java.io.*;
import java.util.*;

public class Main_7568_BOJ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<Person> list = new ArrayList<>();
		int[] rank = new int[n];
		Arrays.fill(rank, 1);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Person p = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list.add(p);
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int res = list.get(i).compareTo(list.get(j));
				if (res == 1)
					rank[j]++;
				else if (res == -1)
					rank[i]++;
			}
			bw.append(rank[i] + " ");
		}
		bw.append("\n");
		bw.flush();
		bw.close();
		br.close();
	}

}

class Person implements Comparable<Person> {
	int height, weight;

	Person(int h, int w) {
		height = h;
		weight = w;
	}

	@Override
	public int compareTo(Person p) {
		if (height > p.height && weight > p.weight)
			return 1;
		else if (height < p.height && weight < p.weight)
			return -1;
		return 0;
	}
}