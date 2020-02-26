package CS3304;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Implementation of Prim's algorithm (lazy approach)
 * and based on Algorithms textbook (Sedgewick)
 * @author Abdulrahman
 *
 */
public class PrimMST {
	
	private boolean[] marked;
	private Queue<Edge> mst;
	private PriorityQueue<Edge> pq;
	
	/**
	 * Constructor for the PrimMST class
	 * @param G the graph under study
	 */
	public PrimMST(Graph G) {
		// priority queue for the edges with 
		// lowest weights
		pq = new PriorityQueue<Edge>();
		
		// the edges in the tree
		mst = new LinkedList<Edge>();
		
		// marks the vertices in the tree
		marked = new boolean[G.V()];
		
		// start by visiting the first vertex
		visit(G, 0);
		
		// loop until all vertices are visited and the 
		// tree is complete with V-1 edges
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
	
	// marks the vertex as part of the tree
	// adds the new edges to the priority queue
	private void visit(Graph G, int v) {
		marked[v] = true;
		for (Edge e : G.adj(v))
			if (!marked[e.otherV(v)])
				pq.add(e);
	}
	
	public Iterable<Edge> mst() {
		return mst;
	}

	public static void main(String[] args) {
		// create new graph and add edges
		// edges are numbered 0 to 7 instead of 1 to 8
		Graph G = new Graph(8);
		G.addEdge(new Edge(0,1,5));
		G.addEdge(new Edge(0,2,4));
		G.addEdge(new Edge(1,2,2));
		G.addEdge(new Edge(1,3,3));
		G.addEdge(new Edge(2,4,4));
		G.addEdge(new Edge(3,6,6));
		G.addEdge(new Edge(4,3,2));
		G.addEdge(new Edge(4,5,1));
		G.addEdge(new Edge(5,6,8));
		G.addEdge(new Edge(6,7,2));
		
		// create an PrimMST object and caluclate the MST
		PrimMST primMST = new PrimMST(G);
		
		int totalCost = 0;
		
		System.out.println("The edges in the MST are:");
		for (Edge e: primMST.mst()){
			System.out.println(e);
			totalCost += e.weight();
		}
		System.out.println("The total cost of the MST"+
				" is = "+totalCost);
		
	}

}
