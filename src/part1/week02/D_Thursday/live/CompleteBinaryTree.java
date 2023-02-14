package part1.week02.D_Thursday.live;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree {
	private char[] nodes;
	private int lastIndex; // 마지막 노드의 인덱스
	private final int SIZE; // 고정된 크기의 이진 트리 만들 예정

	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new char[size + 1]; // 인덱스 1부터 사용하기 위함.
	}

	public boolean add(char e) {
		if (lastIndex == SIZE)
			return false;

		nodes[++lastIndex] = e;
		return true;
	}

	public void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(nodes[cur] + " ");
			if (cur * 2 <= lastIndex) {
				q.offer(cur * 2);
				if (cur * 2 < lastIndex)
					q.offer(cur * 2 + 1);
			}
		}
	}
	public void dfs() {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		while (!s.isEmpty()) {
			int cur = s.pop();
			System.out.print(nodes[cur] + " ");
			if (cur * 2 <= lastIndex) {
				s.push(cur * 2);
				if (cur * 2 < lastIndex)
					s.push(cur * 2 + 1);
			}
		}
	}
}
