package part1.week04.B_Tuesday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1043_BOJ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int peopleN = Integer.parseInt(st.nextToken());
		int partyN = Integer.parseInt(st.nextToken());

		int parent[] = init(peopleN);

		st = new StringTokenizer(br.readLine());
		int knowTruth = Integer.parseInt(st.nextToken());
		for (int i = 0; i < knowTruth; i++) {
			int n = Integer.parseInt(st.nextToken());
			parent[n] = 0;
		}

		ArrayList<Integer> party[]=new ArrayList[partyN];
		for (int i = 0; i < partyN; i++) {
			st = new StringTokenizer(br.readLine());
			party[i]=new ArrayList<>();
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				party[i].add( Integer.parseInt(st.nextToken()));
				for (int k = j - 1; k >= 0; k--) {
					int a = getParent(parent, party[i].get(j));
					int b = getParent(parent, party[i].get(k));
					int bigP = a > b ? a : b;
					int smallP = a < b ? a : b;
					if (bigP != smallP)
						parent[bigP] = smallP;
				}
			}
		}
		int cnt=0;
		for(int i=0;i<partyN;i++) {
			if(getParent(parent,party[i].get(0))!=0)
				cnt++;
		}
		
		System.out.println(cnt);
	}

	private static int[] init(int n) {
		int[] tmp = new int[n + 1];
		for (int i = 1; i <= n; i++)
			tmp[i] = i;
		return tmp;
	}

	static int getParent(int[] parent, int a) {
		if (parent[a] != a)
			parent[a] = getParent(parent, parent[a]);
		return parent[a];
	}
}
