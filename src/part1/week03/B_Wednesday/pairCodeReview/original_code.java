package part1.week03.B_Wednesday.pairCodeReview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class original_code {
	static int M, A;
	static int[] am;
	static int[] bm;
	static int[] dc = { 0, -1, 0, 1, 0 }; // 상우하좌
	static int[] dr = { 0, 0, 1, 0, -1 };
	static List<ArrayList<Integer>> BC;
	static int[] ae;
	static int[] be;
	static int[] aloc;
	static int[] bloc;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			am = new int[M + 1];
			bm = new int[M + 1];
			ae = new int[M + 1];
			be = new int[M + 1];
			aloc = new int[] { 1, 1 };
			bloc = new int[] { 10, 10 };
			st = new StringTokenizer(br.readLine(), " ");
			am[0] = 0;
			bm[0] = 0;
			for (int i = 1; i <= M; i++) {
				am[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				bm[i] = Integer.parseInt(st.nextToken());
			}

			BC = new ArrayList<>();
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// 위치받기
				ArrayList<Integer> xy = new ArrayList<>();
				xy.add(Integer.parseInt(st.nextToken()));
				xy.add(Integer.parseInt(st.nextToken()));
				// 충전범위
				xy.add(Integer.parseInt(st.nextToken()));
				// 성능
				xy.add(Integer.parseInt(st.nextToken()));
				BC.add(xy);
			}

			for (int i = 0; i <= M; i++) {
				move(i, am[i], bm[i], aloc[0], aloc[1], bloc[0], bloc[1]);
			}
			int asum = 0, bsum = 0;
			for (int i = 0; i <= M; i++) {
				asum += ae[i];
				bsum += be[i];
			}

			System.out.println("#" + test_case + " " + (asum + bsum));
		}
	}

	private static void move(int i, int ai, int bi, int ar, int ac, int br, int bc) {
		aloc[0] = ar + dr[ai];
		aloc[1] = ac + dc[ai];
		bloc[0] = br + dr[bi];
		bloc[1] = bc + dc[bi];

		int[] amax = new int[A];
		int[] bmax = new int[A];
		int equal = -1;
		for (int j = 0; j < A; j++) {
			int[] bcloc = new int[] { BC.get(j).get(0), BC.get(j).get(1) };
			int ad = Math.abs(aloc[0] - bcloc[0]) + Math.abs(aloc[1] - bcloc[1]);
			int bd = Math.abs(bloc[0] - bcloc[0]) + Math.abs(bloc[1] - bcloc[1]);

			if (ad <= BC.get(j).get(2) && !(bd <= BC.get(j).get(2))) {
				amax[j] = BC.get(j).get(3);
			} else if (bd <= BC.get(j).get(2) && !(ad <= BC.get(j).get(2))) {
				bmax[j] = BC.get(j).get(3);
			} else if ((ad <= BC.get(j).get(2)) && (bd <= BC.get(j).get(2))) {
				amax[j] = BC.get(j).get(3) / 2; // a랑 b다 선택
				bmax[j] = BC.get(j).get(3) / 2;
				equal = j;
			}
		}

		int maxa = -1, maxb = -1;
		int idxa = 0, idxb = 0;
		for (int j = 0; j < A; j++) {
			if (amax[j] > maxa) {
				maxa = amax[j];
				idxa = j;
			}
			if (bmax[j] > maxb) {
				maxb = bmax[j];
				idxb = j;
			}
		}
		if (idxa == idxb && (maxa != 0 && maxb != 0)) {
			ae[i] = maxa;
			be[i] = maxb;
		} else {
			if (equal == idxa)
				ae[i] = maxa * 2;
			else
				ae[i] = maxa;
			if (equal == idxb)
				be[i] = maxb * 2;
			else
				be[i] = maxb;
		}
	}

}