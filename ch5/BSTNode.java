package ch5;

//Binary tree node implementation: supports comparable objects
class BSTNode implements BinNode {
	private Comparable element; // Element for this node
	private BSTNode left;          // Pointer to left child
	private BSTNode right;         // Pointer to right child

	// Constructors
	BSTNode() {left = right = null; }
	BSTNode(Comparable val) { left = right = null; element = val; }
	BSTNode(Comparable val, BSTNode l, BSTNode r)
	{ left = l; right = r; element = val; }

	// Get and set the element value
	public Comparable value() { return element; }
	public void setValue(Comparable v) { element = v; }
	public void setValue(Object v) { // We need this one to satisfy BinNode interface
		if (!(v instanceof Comparable))
			throw new ClassCastException("A Comparable object is required.");
		element = (Comparable)v;
	}

	// Get and set the left child
	public BSTNode left() { return left; }
	public void setLeft(BSTNode p) { left = p; }

	// Get and set the right child
	public BSTNode right() { return right; }
	public void setRight(BSTNode p) { right = p; }

	// return TRUE if a leaf node, FALSE otherwise
	public boolean isLeaf() { return (left == null) && (right == null); }
	
	/**
	 * A recursive function that increments by one
	 * the value for every node in the binary tree pointed 
	 * at by root, then returns the modified tree. 
	 * Assume that nodes store integer values.
	 * @param root
	 * @return
	 */
	public BSTNode BTinc(BSTNode root)
	{
	    if (root == null) return null;
	    root.setValue((int)root.value()+1);
	    root.left = BTinc(root.left()); 
	    root.right = BTinc(root.right());
	    return root;
	}
	
	/*
	 * A recursive function to set the value for 
	 * each node in a binary tree to be its depth 
	 * then return the modified tree. Assume that 
	 * nodes store integer values. On the initial 
	 * call to BTsetdepth, depth is 0.
	 */
	public BSTNode BTsetdepth(BSTNode root, int depth)
	{
	    if (root == null) return null;
	    root.setValue(depth);
	    root.left = BTsetdepth(root.left, depth+1);
	    root.right = BTsetdepth(root.right, depth+1);
		return root;
	}
	
	/*
	 * Given a binary tree, check if the tree satisfies
	 * the property that for each node, the sum of the
	 * values of its left and right children are equal
	 * to the node's value. If a node has only one child,
	 * then the node should have the same value as that child.
	 * Leaf nodes automatically satisfy the property.
	 */
	public boolean BTchecksum(BSTNode root)
	{
		if (root == null) return true;
		if (root.isLeaf()) return true;
		boolean result;
		if (root.left == null) {
			result = (int)root.value() == (int)root.right.value();
		}
		else if (root.right == null) {
			result = (int)root.value() == (int)root.left.value();
		}
		else result = (int)root.value() == ((int)root.left.value() + (int)root.right.value());
	    return result && BTchecksum(root.left) && BTchecksum(root.right);
	}
}