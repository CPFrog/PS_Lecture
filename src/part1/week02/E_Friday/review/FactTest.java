package part1.week02.E_Friday.review;

public class FactTest {
	public static void main(String[] args) {
		for (int i = 1; i <= 13; i++) {
			System.out.println(i+" : "+fact(i));
		}
	}

	// f(5) = 5*f(4) -> call stack (= 스택 구조와 유사)
	// 자신 호출 -> for/while이 코드에 없음 -> 순환문 -> 끝나는 조건 명시 필요.
	// recursion -> 종료조건(end condition) -> dfs
	// -> BackTracking=dfs+저장+원위치+가지치기(pruning)
	private static int fact(int n) {
		if (n <= 1)
			return 1;
		return n * fact(n - 1);
	}

}
