package DIY;

public class SegmentTree {
	static int[] arr;
	static int[] tree;

	public static void main(String[] args) {
		arr = new int[] { 1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5 };
		int n = arr.length;
		tree = new int[(n - 1) * 4];
		init(0, n - 1, 1);
		System.out.println(sum(0, n - 1, 1, 0, 12));
	}

	private static int init(int start, int end, int node) {
		if (start == end) // 노드의 범위가 1이라면 (== leaf node)
			return tree[node] = arr[start];
		// leaf 노드가 아니라면
		// 자식 노드들을 합친 값을 저장하고 그 값을 반환해주면 됨.
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

	// start: 현재 단계에서의 덧셈 시작 범위
	// end: 현재 단계에서의 덧셈 끝 범위
	// node: 인덱스 번호
	private static int sum(int start, int end, int node, int left, int right) {
		// 덧셈 범위를 벗어난 경우
		if (left > end || right < start)
			return 0; // 유효하지 않은 덧셈 요청이므로 0 반환.
		// 현재 단계의 덧셈 범위(start~end)가 전체 덧셈 범위(left~right)에 포함된 경우
		if (left<=start && end <= right)
			return tree[node]; // 현재 범위의 덧셈 값이 저장된 노드의 내용물을 그대로 반환.
		// 일부만 포함된 경우
		// 범위를 나눠서 포함된 범위만 반환해줌.
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	// dif = 원래 배열안의 값과 새로운 배열안의 값과의의 차이.
	private static void update(int start, int end, int node, int index, int dif) {
		// 업데이트 하려는 배열 인덱스의 범위가 포함되지 않은 노드인 경우
		if (index < start || index > end)
			return;
		// 인덱스를 포함하는 범위의 노드인 경우 자식 노드들도 갱신.
		tree[node] += dif;
		if (start == end)
			return;
		int mid = (start + end) / 2;
		update(start, mid, node * 2, index, dif);
		update(mid + 1, end, node * 2 + 1, index, dif);

	}
}
