package part1.week01.C_Wednesday.review;

import java.util.Arrays;

public class NextPermutationReview {
	static int [] arr= {1,2,3,4,5};
	static int n=arr.length;
	
	
	public static void main(String[] args) {
		int count=0;
		do {
			count++;
			System.out.println(Arrays.toString(arr));
		}while(np(n-1));

	}


	private static boolean np(int cnt) {
		return false;
	}

}
