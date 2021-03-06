package ch6;

//General tree ADT
public class GenTree {
	GTNode root;
	GenTree() {
		this.root = new GTNode(null);
	}
	
	GenTree(Object value,  GTNode first, GTNode sib) {
		this.root = new GTNode(value, first, sib);
	}
	
	GenTree(Object val) {
		this(val, null, null);
	}
	
	public void clear() {
		this.root = null;
	}
	
	public GTNode root() {
		return this.root;
	}   
	
	public void newroot(Object value, GTNode first, GTNode sib) {
		//this.root.leftmostChild = this.root;
		this.root = new GTNode(value, first, sib);
	}
	public void newleftchild(Object value) {
		GTNode temp = new GTNode(value);
		temp.rightSibling = this.root.leftmostChild;
		this.root.leftmostChild = temp;
	}
}