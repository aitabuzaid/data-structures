package ch5;

//Binary Search Tree implementation
public class BST {
	private BSTNode root; // Root of the BST
	private int nodecount; // Number of nodes in the BST

	// constructor
	BST() { root = null; nodecount = 0; }

	// Reinitialize tree
	public void clear() { root = null; nodecount = 0; }

	// Insert a record into the tree.
	// Records can be anything, but they must be Comparable
	// e: The record to insert.
	public void insert(Comparable e) {
		root = inserthelp(root, e);
		nodecount++;
	}

	// Remove a record from the tree
	// key: The key value of record to remove
	// Returns the record removed, null if there is none.
	public Comparable remove(Comparable key) {
		Comparable temp = findhelp(root, key); // First find it
		if (temp != null) {
			root = removehelp(root, key); // Now remove it
			nodecount--;
		}
		return temp;
	}

	// Return the record with key value k, null if none exists
	// key: The key value to find
	public Comparable find(Comparable key) { return findhelp(root, key); }

	// Return the number of records in the dictionary
	public int size() { return nodecount; }

	public void print() {
		printhelp(root);
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(BSTNode root)
	{
		if (root == null) return 0;
	    return 1 + Math.max(height(root.left()), height(root.right()));
	}
	
	
	private Comparable findhelp(BSTNode rt, Comparable key){
		if (rt == null) return null;
		if (rt.value().compareTo(key) > 0)
			return findhelp(rt.left(), key);
		else if (rt.value().compareTo(key) == 0)
			return rt.value();
		else return findhelp(rt.right(), key);
	}

	private BSTNode inserthelp(BSTNode rt, Comparable e) {
		if (rt == null) return new BSTNode(e);
		if (rt.value().compareTo(e) >= 0)
			rt.setLeft(inserthelp(rt.left(), e));
		else
			rt.setRight(inserthelp(rt.right(), e));
		return rt;	
	}

	private BSTNode removehelp(BSTNode rt, Comparable key) {
		if (rt == null) return null;
		if (rt.value().compareTo(key) > 0)
			rt.setLeft(removehelp(rt.left(), key));
		else if (rt.value().compareTo(key) < 0)
			rt.setRight(removehelp(rt.right(), key));
		else {
			if (rt.left() == null) return rt.right();
			else if (rt.right() == null) return rt.left();
			else {
				BSTNode temp = getmax(rt.left());
				rt.setValue(temp.value());
				rt.setLeft(deletemax(rt.left()));
			}
		}
		return rt;
	}

	// Get the maximum valued element in a subtree
	private BSTNode getmax(BSTNode rt) {
		if (rt.right() == null) return rt;
		return getmax(rt.right());
	}

	private BSTNode deletemax(BSTNode rt) {
		if (rt.right() == null) return rt.left();
		rt.setRight(deletemax(rt.right()));
		return rt;
	}

	
	private void printhelp(BSTNode rt) {
		if (rt == null) return;
		printhelp(rt.left());
		printVisit(rt.value());
		printhelp(rt.right());
	}
	private void printVisit(Comparable value) {
		System.out.print(" "+value+" ");
	}

}
