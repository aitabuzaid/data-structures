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
}
