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

}

class Solution {
	public static int solution(int n, int[][] edge) {

		Graph g = new Graph(n);
		int max = 0;
		int cnt = 0;
		
		for (int i = 0; i < edge.length; i++)
			g.put(edge[i][0], edge[i][1]);

		g.bfs(1);
		
		for (int k : g.dis) {
			if(k > max) {
				cnt = 0;
				max = k;
			}
			if(k == max)
				cnt++;
		}

		return cnt;
	}
}