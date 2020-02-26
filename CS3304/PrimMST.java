package CS3304;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimMST {
	
	private boolean[] marked;
	private Queue<Edge> mst;
	private PriorityQueue<Edge> pq;
	
	public PrimMST(Graph G) {
		pq = new PriorityQueue<Edge>();
		mst = new LinkedList<Edge>();
		marked = new boolean[G.V()];
		visit(G, 0);
		
		while(!pq.isEmpty() && mst.size() < G.V()-1){
			Edge e = pq.remove();
			int v = e.eitherV();
			int w = e.otherV(v);
			if (marked[v] && marked[w]) continue;
			mst.add(e);
			if(!marked[v]) visit(G,v);
			if(!marked[w]) visit(G,w);
		}
	}
	
	private void visit(Graph G, int v) {
		marked[v] = true;
		for (Edge e : G.adj(v))
			if (!marked[e.otherV(v)])
				pq.add(e);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
