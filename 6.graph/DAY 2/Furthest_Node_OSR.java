package Graph;

import java.util.*;

class Graph {
	private int nV;
	private ArrayList<ArrayList<Integer>> graph;
	private boolean[] visited;
	private Queue<Integer> queue;
	public int[] dis;

	public Graph(int initSize) {

		this.nV = initSize;
		this.visited = new boolean[initSize + 1];
		this.dis = new int[initSize + 1];
		this.graph = new ArrayList<ArrayList<Integer>>();
		this.queue = new LinkedList<>();

		for (int i = 0; i < initSize + 1; i++)
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

	public void bfs(int vIdx) {

		int cnt;

		queue.add(vIdx);
		visited[vIdx] = true;

		while (!queue.isEmpty()) {
			vIdx = queue.poll();
			cnt = dis[vIdx] + 1;
			
			for (int k : this.graph.get(vIdx)) {
				if (!visited[k]) {
					queue.add(k);
					visited[k] = true;
					dis[k] = cnt;
				}
			}
		}
	}

	public boolean isValid(int start, int end) {
		dfs(start);

		if (visited[end] == false)
			return false;

		return true;
	}

	public int getVirus(int v) {
		dfs(v);

		int cnt = 0;
		for (int i = 2; i < nV + 1; i++) {
			if (visited[i] == true)
				cnt++;

		}

		return cnt;
	}

	public void printGraph() {

		for (int i = 1; i < this.graph.size(); i++) {
			System.out.print("v: " + i + " -> "); 
			for (int j = 0; j < this.graph.get(i).size(); j++) {
				System.out.print(this.graph.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}

public class Furthest_Node_OSR {

	public static int solution(int n, int[][] edge) {

		Graph g = new Graph(n);
		int max = 0;
		int cnt = 0;
		
		for (int i = 0; i < edge.length; i++)
			g.put(edge[i][0], edge[i][1]);

		g.bfs(1);
		
		for (int k : g.dis) {
			//System.out.print(k + " ");
			if(k > max) {
				cnt = 0;
				max = k;
			}
			if(k == max)
				cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) {
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		System.out.print(solution(6, edge));

	}

}
