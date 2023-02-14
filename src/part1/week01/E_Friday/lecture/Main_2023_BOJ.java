package part1.week01.E_Friday.lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2023_BOJ {
	static int N;
	static int[] nums;
	static int[] q= {2,3,5,7};
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		for (int i = 0; i < 4; i++) {
			nums=new int[N];
			nums[0]=q[i];  // 첫자리를 주고 시작
			npir(0);
		}
	}
	// 중복순열 공식 최악 9^N
	private static void npir(int cnt) {
		int nn=toI(nums,cnt+1);
		if(!isP(nn)) return ; // 솟수가 아니면 끝내 
		//prunning 가지치기 nums -> int로 변환
		// 숫자를 모두 만들지 말고 만드는 과정에서도 소수가 아니면 버림
		if(cnt==N-1) {
			System.out.println(nn);
			return ;
		}
		for (int i = 0; i <9; i++) {
			nums[cnt+1]=(i+1);// 1~9를선택
			npir(cnt+1);
			//nums[cnt]=0;
		}
	}
	private static int toI(int[] nums2, int nn) {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < nn; i++) {
			sb.append(nums2[i]);
		}
		return Integer.parseInt(sb.toString());
	}

	private static boolean isP(int n) {
		if(n==1) return false;
		for (int i = 2; i <= (int)(Math.sqrt(n)); i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}