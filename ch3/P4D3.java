package ch3;
import java.util.*;

// Function to reverse order 
// of Queue elements using a stack

public class P4D3 {
	

	public static void main(String args[]) {
		LinkedList<Integer> intList1 = new LinkedList<Integer>();
		LinkedList<Integer> intList2 = new LinkedList<Integer>();
		
		for (int i = 0; i < 30; i++) {
			int int1 = (int)(10*Math.random());
			int int2 = (int)(10*Math.random());
			intList1.add(int1);
			intList2.add(int2);
		}
		
		System.out.println(intList1);
		System.out.println(intList2);
		System.out.println(add(intList1, intList2));
	}
	
	
	
	public static LinkedList<Integer> add(LinkedList<Integer> intList1, LinkedList<Integer> intList2) {
		LinkedList<Integer> resList = new LinkedList<Integer>();
		
		while (!intList1.isEmpty() || !intList2.isEmpty()) {
			
		}
		return resList;
	}
}
