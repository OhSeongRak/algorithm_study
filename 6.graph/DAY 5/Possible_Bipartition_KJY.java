import java.util.ArrayList;

class Graph {
	ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	boolean[] visited;

	Graph(int n) {
		for (int i = 0; i <= n; i++) {
			ArrayList<Integer> vertex = new ArrayList<Integer>();
			vertex.add(i);
			graph.add(vertex);
		}
		visited = new boolean[n + 1];
	}

	void AddEdgeInfo(int n1, int n2) {
		graph.get(n1).add(n2);
	}

	boolean DFS(int start) {
		visited[start] = true;
		for (int next : graph.get(start)) {
			if (next == start)
				continue;
			if (visited[next] == true)
				return false;
			else
				return DFS(next);
		}
		return true;
	}

}

class Solution {

	public boolean possibleBipartition(int n, int[][] dislikes) {
		Graph graph = new Graph(n);
		for (int i = 0; i < dislikes.length; i++) {
			graph.AddEdgeInfo(dislikes[i][0], dislikes[i][1]);
		}
		for (int i = 1; i <= n; i++) {
			graph.visited = new boolean[n+1];
			if (graph.DFS(i) == false)
				return false;
		}
		return true;

	}
}
