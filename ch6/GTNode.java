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
	
	static boolean GTComp(GTNode rt1, GTNode rt2) {
        boolean result = true;
        if (!rt1.isLeaf() && rt2.isLeaf()) return false;
        else if (rt1.isLeaf() && !rt2.isLeaf()) return false;
        else if (rt1.isLeaf() && rt2.isLeaf()) return rt1.value() == rt2.value();
        else {
            GTNode temp1 = rt1.leftmostChild();
            GTNode temp2 = rt2.leftmostChild();
            while (temp1 != null && temp2 != null) {
                result &= GTComp(temp1, temp2);
                temp1 = temp1.rightSibling();
                temp2 = temp2.rightSibling();
            }
            if ((temp1 == null && temp2 != null) || (temp1 != null && temp2 == null)) return false;
        }
        return result;
    }
}