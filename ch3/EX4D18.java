package ch3;
import java.util.*;

// Function to reverse order 
// of Queue elements using a stack

public class EX4D18 {
	

	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < 20; i++)
			queue.add(i);
		
		System.out.println(queue);
		EX4D18.reverse(queue, stack);
		System.out.println(queue);
	}
	
	public static Queue<Integer> reverse(Queue<Integer> queue, Stack<Integer> stack) {
		while (!queue.isEmpty()) {
			stack.add(queue.remove());
		}
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		return queue;
	}
}
