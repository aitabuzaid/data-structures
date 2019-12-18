package ch6;

//General tree node ADT
public interface GTNode {
	public Object value();
	public boolean isLeaf();
	public GTNode parent();
	public GTNode leftmostChild();
	public GTNode rightSibling();
	public void setValue(Object value);
	public void setParent(GTNode par);
	public void insertFirst(GTNode n);
	public void insertNext(GTNode n);
	public void removeFirst();
	public void removeNext();
	public static void printNode(GTNode n){};


	static void postorder(GTNode rt) {
		if (!rt.isLeaf()) {
			GTNode temp = rt.leftmostChild();
			while (temp != null) {
				postorder(temp);
				temp = temp.rightSibling();
			}
		}
		printNode(rt);
	}
}