package ch5;

//Binary Search Tree implementation
public class AVLTree {
	private BSTNode root; // Root of the BST
	private int nodecount; // Number of nodes in the BST

	// constructor
	AVLTree() { root = null; nodecount = 0; }

	// Reinitialize tree
	public void clear() { root = null; nodecount = 0; }

	// Insert a record into the tree.
	// Records can be anything, but they must be Comparable
	// e: The record to insert.
	public void insert(Comparable e) {
		root = inserthelp(root, e);
		nodecount++;
	}
	
	private BSTNode inserthelp(BSTNode rt, Comparable e) {
		if (rt == null) return new BSTNode(e);
		if (rt.value().compareTo(e) >= 0)
			rt.setLeft(inserthelp(rt.left(), e));
		else
			rt.setRight(inserthelp(rt.right(), e));
		
		return rt;	
	}
	
	private BSTNode leftRotate(BSTNode root) {
		if (root == null) return root;
		BSTNode rightNode = root.right();
		root.setRight(rightNode.left());
		rightNode.setLeft(root);
		
		root.setHeight(Math.max(height(root.left()),
				height(root.right()))+1);
		root.setHeight(Math.max(height(rightNode.left()),
				height(rightNode.right()))+1);
		
		return rightNode;
	}
	
	private BSTNode rightRotate(BSTNode root) {
		if (root == null) return root;
		BSTNode leftNode = root.left();
		root.setLeft(leftNode.right());
		leftNode.setRight(root);
		
		root.setHeight(Math.max(height(root.left()),
				height(root.right()))+1);
		root.setHeight(Math.max(height(leftNode.left()),
				height(leftNode.right()))+1);
		
		return leftNode;
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
	
	public int height(BSTNode root)
	{
		return root.getHeight();
	}
	
	
	private Comparable findhelp(BSTNode rt, Comparable key){
		if (rt == null) return null;
		if (rt.value().compareTo(key) > 0)
			return findhelp(rt.left(), key);
		else if (rt.value().compareTo(key) == 0)
			return rt.value();
		else return findhelp(rt.right(), key);
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
		printVisit(rt);
		printhelp(rt.right());
	}
	private void printVisit(BSTNode node) {
		System.out.print(" "+node.value()+" height:"+
	node.getHeight());
	}

}
