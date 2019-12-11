package ch5;
import java.util.*;

public class testBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		System.out.println("Enter any integer (enter e/E to exit):");
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String input = in.next();
			if (input.toLowerCase().equals("e"))
				break;
			bst.insert(Integer.parseInt(input));
			System.out.println("Enter any integer (enter e/E to exit):");
		}
		System.out.println("Printing the BST: ");
		bst.print();
		System.out.println("\n"+bst.height());
		System.out.println("\nExited...");
		
	}

}
