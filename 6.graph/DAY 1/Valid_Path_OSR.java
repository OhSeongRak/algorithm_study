package Graph;

import java.util.ArrayList;

class Graph {
	private int nV;
	private ArrayList<ArrayList<Integer>> graph;
	private boolean[] visited;

	public Graph(int initSize) {

		this.nV = initSize;
		this.visited = new boolean[initSize + 1];
		this.graph = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < initSize; i++)
			graph.add(new ArrayList<Integer>());
	}

	public void put(int x, int y) {
		graph.get(x).add(y);
		graph.get(y).add(x);
	}

	public void dfs(int vIdx) {
		this.visited[vIdx] = true;

		for (int i : this.graph.get(vIdx)) {
			if (this.visited[i] == false)
				dfs(i);
		}

	}

	public boolean isValid(int start, int end) {
		dfs(start);

		if (visited[end] == false)
			return false;

		return true;
	}

}

public class Valid_Path_OSR {
	public static boolean validPath(int n, int[][] edges, int start, int end) {

		Graph g = new Graph(n);

		for (int i = 0; i < edges.length; i++)
			g.put(edges[i][0], edges[i][1]);

		return g.isValid(start, end);
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };

		System.out.print(validPath(6, edges, 0, 5));

	}

}
