package part1.week04.B_Tuesday;

import java.io.*;
import java.util.*;

public class Main_4195_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> parents = new ArrayList<>();
			ArrayList<Integer> networks = new ArrayList<>();
			HashMap<String, Integer> hm = new HashMap<>();

			int cnt = 0;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String p1 = st.nextToken();
				if (!hm.containsKey(p1)) {
					hm.put(p1, cnt);
					parents.add(cnt++);
					networks.add(1);
				}
				String p2 = st.nextToken();
				if (!hm.containsKey(p2)) {
					hm.put(p2, cnt);
					parents.add(cnt++);
					networks.add(1);
				}
				union(parents, networks, hm.get(p1), hm.get(p2));
				sb.append(networks.get(getParent(parents, hm.get(p1)))+"\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void union(ArrayList<Integer> parents, ArrayList<Integer> networks, int p1, int p2) {
		int a = getParent(parents, p1);
		int b = getParent(parents, p2);
		if (a != b) {
			int big = a > b ? a : b;
			int small = a < b ? a : b;
			parents.set(big, small);
			networks.set(small, networks.get(big)+networks.get(small));
		}
	}

	private static int getParent(ArrayList<Integer> parents, int a) {
		if (parents.get(a) != a)
			parents.set(a, getParent(parents, parents.get(a)));
		return parents.get(a);
	}
}
