package part1.week02.A_Monday.live;

public class StackTest {
	public static void main(String[] args) {
		IStack<String> stack = new SsafyStack<>();
		System.out.println(stack.isEmpty() + "/" + stack.size());

		stack.push("비봉이");
		stack.push("대포");
		stack.push("금등이");

		System.out.println("peek from stack: " + stack.peek());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		System.out.println("pop from stack: " + stack.pop());
		System.out.println("pop from stack: " + stack.pop());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		System.out.println("pop from stack: " + stack.pop());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		stack.pop();
	}

}
