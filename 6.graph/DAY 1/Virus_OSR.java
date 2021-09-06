package Graph;

import java.util.ArrayList;
import java.util.Scanner;

class Graph {
	private int nV;
	private ArrayList<ArrayList<Integer>> graph;
	private boolean[] visited;

	public Graph(int initSize) {

		this.nV = initSize;
		this.visited = new boolean[initSize + 1];
		this.graph = new ArrayList<ArrayList<Integer>>();

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

}

public class Virus_OSR {

	public static void main(String[] args) {
		int nV, k, x, y;
		Scanner sc = new Scanner(System.in);

		nV = sc.nextInt();
		k = sc.nextInt();

		Graph g = new Graph(nV);

		for (int i = 0; i < k; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			g.put(x, y);
		}

		System.out.print(g.getVirus(1));
	}

}
