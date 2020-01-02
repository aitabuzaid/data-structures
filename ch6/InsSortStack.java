package ch6;
import java.util.*;

/**
 * Insertion sort algorithm that uses two stacks
 * other than the input stack, one stack is used
 * as output and another as a temp. stack to allow
 * for popped items from the output stack to be 
 * saved while the next item is inserted in position
 * The algorithm has O(n^2) complexity since inserting each
 * item could take require half of the elements in the stack
 * to be popped and pushed back, and hence, inserting n items
 * requires n*(n-1) ~ n^2
 * @author Abdulrahman
 *
 */

public class InsSortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Comparable> stack = new Stack<Comparable>();
		for (int i = 0; i < 20; i++) {
			stack.push((int)(Math.random()*50));
		}
		System.out.println(stack);
		System.out.println(InsSortStack.sort(stack));
	}
	public static Stack<Comparable> sort(Stack<Comparable> inStack){
		Stack<Comparable> tempStack = new Stack<Comparable>();
		Stack<Comparable> outStack = new Stack<Comparable>();
		Comparable tempItem;
		while (!inStack.isEmpty()) {
			tempItem = inStack.pop();
			while (!outStack.isEmpty() && tempItem.compareTo(outStack.peek()) > 0) {
				tempStack.push(outStack.pop());
			}
			outStack.push(tempItem);
			while (!tempStack.isEmpty()) outStack.push(tempStack.pop());
		}


		return outStack;
	}

}
