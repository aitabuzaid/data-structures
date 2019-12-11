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
	
	private BSTNode inserthelp(BSTNode root, Comparable e) {
		if (root == null) return new BSTNode(e);
		if (root.value().compareTo(e) >= 0)
			root.setLeft(inserthelp(root.left(), e));
		else
			root.setRight(inserthelp(root.right(), e));
		
		if (root.left() == null && root.right() == null)
			root.setHeight(-1);
		else
			root.setHeight(Math.max(height(root.left()),height(root.right()))+1);
		
		
		if ((height(root.left()) - height(root.right())) > 1)
			if ((height(root.left().left())-height(root.left().right()))>0)
				return rightRotate(root);
			else {
				root.setLeft(leftRotate(root.left()));
				return rightRotate(root);
			}
		else if ((height(root.left()) - height(root.right())) < -1)
			if ((height(root.right().left())-height(root.right().right()))<0)
				return leftRotate(root);
			else {
				root.setRight(rightRotate(root.right()));
				return leftRotate(root);
			}		
		
		return root;	
	}
	
	private BSTNode leftRotate(BSTNode root) {
		if (root == null) return root;
		BSTNode rightNode = root.right();
		root.setRight(rightNode.left());
		rightNode.setLeft(root);
		
		root.setHeight(Math.max(height(root.left()),
				height(root.right()))+1);
		rightNode.setHeight(Math.max(height(rightNode.left()),
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
		leftNode.setHeight(Math.max(height(leftNode.left()),
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
		if (root == null) return 0;
		return root.getHeight();
	}
	
	
	private Comparable findhelp(BSTNode root, Comparable key){
		if (root == null) return null;
		if (root.value().compareTo(key) > 0)
			return findhelp(root.left(), key);
		else if (root.value().compareTo(key) == 0)
			return root.value();
		else return findhelp(root.right(), key);
	}

	

	private BSTNode removehelp(BSTNode root, Comparable key) {
		if (root == null) return null;
		if (root.value().compareTo(key) > 0)
			root.setLeft(removehelp(root.left(), key));
		else if (root.value().compareTo(key) < 0)
			root.setRight(removehelp(root.right(), key));
		else {
			if (root.left() == null) return root.right();
			else if (root.right() == null) return root.left();
			else {
				BSTNode temp = getmax(root.left());
				root.setValue(temp.value());
				root.setLeft(deletemax(root.left()));
			}
		}
		return root;
	}

	// Get the maximum valued element in a subtree
	private BSTNode getmax(BSTNode root) {
		if (root.right() == null) return root;
		return getmax(root.right());
	}

	private BSTNode deletemax(BSTNode root) {
		if (root.right() == null) return root.left();
		root.setRight(deletemax(root.right()));
		return root;
	}

	
	private void printhelp(BSTNode root) {
		if (root == null) return;
		printhelp(root.left());
		printVisit(root);
		printhelp(root.right());
	}
	private void printVisit(BSTNode node) {
		System.out.print(" "+node.value()+" height:"+
	node.getHeight());
	}

}
