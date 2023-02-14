package part1.week02.A_Monday.live;

public class SsafyStack<E> implements IStack<E> {

	private Node<E> top; // 더미노드 아님. 첫 원소의 내용물 가지고있음.

	@Override
	public void push(E data) {
		top = new Node<E>(data, top);
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			System.out.println("Error: 스택이 비어있어 pop 명령을 수행할 수 없습니다.");
			return null;
		}

		Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			System.out.println("Error: 스택이 비어있어 peek 명령을 수행할 수 없습니다.");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int cnt = 0;
		for (Node<E> tmp = top; tmp != null; tmp = tmp.link) {
			++cnt;
		}
		return cnt;
	}

}
