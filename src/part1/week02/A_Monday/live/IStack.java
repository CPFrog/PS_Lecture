package part1.week02.A_Monday.live;

public interface IStack<T> {
	void push(T t);
	T pop(); // 맨 위의 원소를 뽑아서 반환해줌
	T peek(); // 맨 위의 원소의 내용만 반환해줌.
	boolean isEmpty();
	int size();

}
