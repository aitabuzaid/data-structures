package ch3;
import java.util.*;

public class EX4D17 {
	

	public static void main(String args[]) {
		Stack<Node> stack = new Stack<Node>();
		double n = 13;
		double result = 0;
		stack.push(new Node(1, n));
		Node temp;
		while (!stack.isEmpty()) {

			temp = stack.pop();
			n = temp.val;
			if (temp.type == Node.ITER) {
				if (n == 1)
					result += 1;
				else {
					stack.push(new Node(Node.ITER, Math.ceil(n/2)));
					stack.push(new Node(Node.ITER, Math.floor(n/2)));
					stack.push(new Node(Node.TERMINAL, n));
				}
			}
			else
				result += n;
		}
		System.out.println("Stack = " + result);
	}
}
