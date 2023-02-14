package part1.week01.D_Thursday.WebX;

public class NextCombination_Another {
	static int[] check = { 0, 0, 0, 1, 1 }; // 이 배열이 다음 순열 구하는 함수에서 사용됩니다.
	static int[] p = { 1, 2, 3, 4, 5 };
	static int nums;
	static int n = p.length;
	static int cnt;

	public static void main(String[] args) {
		do {
			cnt++;
			for (int i = 0; i < n; i++) {
				if (check[i] == 0) // 해당 인덱스의 체크배열 값이 0이라면 
					System.out.print(p[i] + " "); //원 배열에서 해당 인덱스에 해당하는 값을 그대로 출력시킵니다.
			}
			System.out.println();
		} while (np(n - 1));

		System.out.println("조합의 갯수: "+cnt);
	}
	
	// Permutation 코드를 그대로 사용하는 대신 다음 순열을 구하는 배열만 0과 1로만 되어있습니다. 
	private static boolean np(int size) {
		int i = size;
		while (i > 0 && check[i - 1] >= check[i]) // 배열(check) 안에 중복되는 숫자가 있기 때문에 부등호가 > 에서 >=로 바뀝니다.
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (check[i - 1] >= check[j]) // 배열(check) 안에 중복되는 숫자가 있기 때문에 부등호가 > 에서 >=로 바뀝니다.
			j--;
		int tmp = check[i - 1];
		check[i - 1] = check[j];
		check[j] = tmp;
		int k = size;
		while (i < k) {
			tmp = check[i];
			check[i++] = check[k];
			check[k--] = tmp;
		}
		return true;
	}

}
