package ch6;

//General tree node ADT
// General tree node ADT

public class GTNode {
    private Object value;
    GTNode leftmostChild, rightSibling;
    GTNode(Object value) {
        this.value = value;
    } 

    GTNode(Object value, GTNode left, GTNode right) {
        this.value = value;
        this.leftmostChild = left;
        this.rightSibling = right;
    }

    public Object value() {
        return this.value;
    }

    public boolean isLeaf() {
        return this.leftmostChild == null;
    }

    //public GTNode parent();
    public GTNode leftmostChild() {
        return this.leftmostChild;
    }

    public GTNode rightSibling() {
        return this.rightSibling;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
    //public void setParent(GTNode par);

    //public void insertFirst(GTNode n);

    //public void insertNext(GTNode n);

    //public void removeFirst();

    //public void removeNext();


	static void postorder(GTNode rt) {
		if (!rt.isLeaf()) {
			GTNode temp = rt.leftmostChild();
			while (temp != null) {
				postorder(temp);
				temp = temp.rightSibling();
			}
		}
		System.out.print(rt.value());
	}
	
	static boolean GTComp(GTNode rt1, GTNode rt2) {
        boolean result = true;
        if ((!rt1.isLeaf() && rt2.isLeaf()) ||
        		(rt1.isLeaf() && !rt2.isLeaf())) return false;
        else if (rt1.isLeaf() && rt2.isLeaf()) 
        	return rt1.value() == rt2.value();
        else {
            GTNode temp1 = rt1.leftmostChild();
            GTNode temp2 = rt2.leftmostChild();
            while (temp1 != null && temp2 != null) {
                result &= GTComp(temp1, temp2);
                temp1 = temp1.rightSibling();
                temp2 = temp2.rightSibling();
            }
            if ((temp1 == null && temp2 != null) ||
            		(temp1 != null && temp2 == null)) return false;
        }
        return result;
    }
	
	static int GTCount(GTNode rt) {
        int count = 0;
        if (rt == null) return 0;
        if (rt.isLeaf()) return 1;
        else {
            count++;
            GTNode temp = rt.leftmostChild();
            while (temp != null) {
                count += GTCount(temp);
                temp = temp.rightSibling();
            }
        }
        return count;
    }
}