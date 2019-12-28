package ch6;
import java.util.*;

public class InsSortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

	}
	return outStack;
}

}
