package ch3;

// helper class for 
public class Node {
	static int TERMINAL = 0;
	static int ITER = 1;
	double val;
	int type;
	Node (int type, double val) {
		this.type = type;
		this.val = val;
	}
}