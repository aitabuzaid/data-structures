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
}

