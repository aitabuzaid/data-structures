package ch5;
import java.util.*;

public class testBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		System.out.println("Enter an integer between 1 and 40 to search for:");
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String input = in.next();
			if (input.toLowerCase().equals("e"))
				break;
			bst.insert(Integer.parseInt(input));
			bst.print();
		}
		System.out.println("Exited");
		
	}

}
