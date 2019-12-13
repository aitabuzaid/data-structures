package ch5;

//Binary tree node implementation: supports comparable objects
class BSTNode implements BinNode {
	private Comparable element; // Element for this node
	private BSTNode left;          // Pointer to left child
	private BSTNode right;         // Pointer to right child
	private int height;
	
	// Constructors
	BSTNode() {left = right = null; }
	BSTNode(Comparable val) { 
		left = right = null;
		element = val;
		this.height = 1;}
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
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return this.height;
	}
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
	
	/*
	 * A recursive function to count the number of 
	 * leaf nodes in the binary tree pointed at by root. 
	 */
	public int BTleaf(BSTNode root)
	{
	    if (root == null) return 0;
		if (root.isLeaf()) return 1;
		return BTleaf(root.left) + BTleaf(root.right);
	}
	
	/*
	 * A recursive function that returns the sum of 
	 * the values for all of the nodes of the binary
	 * tree by passing the root
	 */
	public int BTsumall(BSTNode root)
	{
		if (root == null) return 0;
	    return (int)root.value()+BTsumall(root.left)+BTsumall(root.right);
	}
	
	/*
	 * A recursive function that returns true if 
	 * there is a node in the given binary tree 
	 * with the given value, and false otherwise. 
	 * Note that this tree is not a Binary Search Tree.
	 */
	public boolean BTcheckval(BSTNode root, int value)
	{
	    if (root == null) return false;
		return (int)root.value()==value || 
				BTcheckval(root.left, value) ||
				BTcheckval(root.right, value);
	}
	
	/*
	 * A recursive function to find the height of
	 * the binary tree pointed at by root
	 */
	public int BTheight(BSTNode root)
	{
	    if (root == null) return 0;
	    return 1 + Math.max(BTheight(root.left), BTheight(root.right));
	}

	
	/*
	 * A recursive function that returns the difference 
	 * between the sum of all node values at odd levels 
	 * and sum of all node values at even levels.
	 * The root node is at level 1.
	 */
	public int BTgetdiff(BSTNode root)
	{
		int level = 0;
		int[] result = BTgetdiff(root, level);
	    return result[1]-result[0];
	}
	
	public int[] BTgetdiff(BSTNode root, int level)
	{
		
		int[] sum = {0, 0}, temp1, temp2;
		if (root == null) return sum;
		level++;
		temp1 = BTgetdiff(root.right, level);
		temp2 = BTgetdiff(root.left, level);
		
		if (level % 2 == 0) {
			sum[0] = (int)root.value()+temp1[0]+temp2[0];
			sum[1] = temp1[1]+temp2[1];
		}
		else {
			sum[0] = temp1[0]+temp2[0];
			sum[1] = (int)root.value()+temp1[1]+temp2[1];
		}
			
	    return sum;
	}
	
	
	/*
	 * A "root-to-leaf path" is any sequence of nodes
	 * in a tree starting with the root node and 
	 * proceeding downward to a leaf. 
	 * The "root-to-leaf path sum" for that path is 
	 * the sum of the values for all the nodes 
	 * (including the root) along that path. 
	 * An empty tree contains no root-to-leaf paths 
	 * (and so its sum is zero). A tree with one node 
	 * to have a root-to-leaf path consisting of just 
	 * the root (and so its sum is the value of the root). 
	 * Given a binary tree and a value sum, return 
	 * true if the tree has some root-to-leaf path 
	 * such that adding up all the values along the 
	 * path equals sum. Return false if no such path 
	 * exists.
	 */
	public boolean BTpathsum(BSTNode root, int sum)
	{
		int sumPath = 0;
	    return BTpathsum(root, sum, sumPath);
	}
	
	public boolean BTpathsum(BSTNode root, int sum, int sumPath)
	{
	    if (root == null) return (sum == sumPath);
	    boolean result = false;
	    result |= BTpathsum(root.left, sum, sumPath+(int)root.value());
	    result |= BTpathsum(root.right, sum, sumPath+(int)root.value());
	    return result;
	}
	
	/*
	 * Given two binary trees, returns true if and only if they
	 * are structurally identical (they have the same shape, 
	 * but their nodes can have different values).
	 */
	public boolean MBTstructure(BSTNode root1, BSTNode root2)
	{
		boolean result = true;
	    if ((root1 == null) && (root2==null)) return true;
	    else if ((root1 == null) && (root2 != null)) return false;
	    else if ((root1 != null) && (root2 == null)) return false;
	    else {
	    	result &= MBTstructure(root1.left(), root2.left());
	    	result &= MBTstructure(root1.right(), root2.right());
	    }
		return result;
	}
}
