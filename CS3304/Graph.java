package CS3304;

import java.util.LinkedList;

public class Graph {
	private final int V;
	private int E;
	private LinkedList<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList();
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void addEdge(int v, int w) {
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

}
