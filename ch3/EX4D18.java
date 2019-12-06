package ch3;
import java.util.*;

// Function to reverse order 
// of Queue elements using a stack

public class EX4D18 {
	

	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();	
		EX4D18.reverse(queue, stack);
	}
	
	public static Queue<Integer> reverse(Queue<Integer> queue, Stack<Integer> stack) {
		return queue;
	}
}
