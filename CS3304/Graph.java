package CS3304;

import java.util.LinkedList;

public class Graph {
	private final int V;
	private int E;
	private LinkedList<Edge>[] adj;

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Edge>();
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void addEdge(Edge e) {
		E++;
		int v = e.eitherV();
		int w = e.otherV(v);
		adj[v].add(e);
		adj[w].add(e);
	}
	
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

}
