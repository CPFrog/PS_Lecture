package part1.week02.A_Monday.live;

public class Node<T> {

	T data;
	Node<T> link;

	public Node(T data, Node<T> link) {
		super();
		this.data = data;
		this.link = link;
	}

	public Node(T data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLink() {
		return link;
	}

	public void setLink(Node<T> link) {
		this.link = link;
	}

}
