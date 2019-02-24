
public class ArrayStackTest {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(10);

		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");

		while (!stack.isEmpty()) {
			String s = stack.pop();
			System.out.print(s + " ");
		}
	}
}
