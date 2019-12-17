package ch6;

//General tree ADT
public interface GenTree {
	public void clear();      // Clear the tree
	public GTNode root();     // Return the root
	//Make the tree have a new root, give first child and sib
	public void newroot(Object value, GTNode first, GTNode sib);
	public void newleftchild(Object value); // Add left child
}