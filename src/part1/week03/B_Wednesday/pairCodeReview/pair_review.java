package part1.week03.B_Wednesday.pairCodeReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class pair_review {
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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			am = new int[M + 1]; // a가 움직이는 경로
			bm = new int[M + 1]; // b가 움직이는 경로
			ae = new int[M + 1]; // a가 얻는 이득
			be = new int[M + 1]; // b가 얻는 이득
			aloc = new int[] { 1, 1 }; // 사람 A의 현재 위치
			bloc = new int[] { 10, 10 }; // 사람 B의 현재 위치
			st = new StringTokenizer(br.readLine());
			am[0] = 0;
			bm[0] = 0;
			// A 경로 입력받음
			for (int i = 1; i <= M; i++) 
				am[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			// B 경로 입력받음
			for (int i = 1; i <= M; i++)
				bm[i] = Integer.parseInt(st.nextToken());

			BC = new ArrayList<>(); // 모든 충전기에 대한 정보 (0 - 행좌표, 1- 열좌표, 2-충전범위, 3-충전량)
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
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

//			System.out.println(Arrays.toString(ae)+"\n"+Arrays.toString(be));
			System.out.println("#" + t + " " + (asum + bsum));
		}
	}

	private static void move(int i, int ai, int bi, int ar, int ac, int br, int bc) {
		aloc[0] = ar + dr[ai];
		aloc[1] = ac + dc[ai];
		bloc[0] = br + dr[bi];
		bloc[1] = bc + dc[bi];

		int[] aWithCharger = new int[A];
		int[] bWithCharger = new int[A];
		int equal = -1;
		ArrayList<Integer> duplicate=new ArrayList<>();
		for (int j = 0; j < A; j++) {
			int[] bcloc = new int[] { BC.get(j).get(0), BC.get(j).get(1) };
			int ad = Math.abs(aloc[0] - bcloc[0]) + Math.abs(aloc[1] - bcloc[1]);
			int bd = Math.abs(bloc[0] - bcloc[0]) + Math.abs(bloc[1] - bcloc[1]);

			if (ad <= BC.get(j).get(2) && bd > BC.get(j).get(2)) {
				aWithCharger[j] = BC.get(j).get(3);
			} else if (bd <= BC.get(j).get(2) && ad > BC.get(j).get(2)) {
				bWithCharger[j] = BC.get(j).get(3);
			} else if ((ad <= BC.get(j).get(2)) && (bd <= BC.get(j).get(2))) {
				aWithCharger[j] = BC.get(j).get(3) / 2; // a랑 b다 선택
				bWithCharger[j] = BC.get(j).get(3) / 2;
				duplicate.add(j);
			}
		}

		int maxa = 0, maxb = 0;
		int sumMax=0;
		int idxa = 0, idxb = 0;
		int idx=0;
		for (int j = 0; j < A; j++) {
			for(int k=0;k<A;k++){
				if(j!=k) {
					int aval=duplicate.contains(j)?aWithCharger[j]*2:aWithCharger[j];
					int bval=duplicate.contains(k)?bWithCharger[k]*2:bWithCharger[k];
					if(sumMax<aval+bval) {
						sumMax=aval+bval;
						idxa=j;
						idxb=k;
						maxa=aval;
						maxb=bval;
					}
				}else {
					if(sumMax<aWithCharger[j]+bWithCharger[k]) {
						sumMax=aWithCharger[j]+bWithCharger[k];
						idxa=j;
						idxb=k;
						maxa=aWithCharger[j];
						maxb=bWithCharger[k];
					}
				}
			}
		}
		ae[i]=maxa;
		be[i]=maxb;
	}

}