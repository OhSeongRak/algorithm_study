package graph;

import java.util.*;

class Edge {
	int v, weight;

	Edge(int v, int w) {
		this.v = v;
		this.weight = w;
	}
}

public class Shortest_Route_OSR {

	final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt();
		List<Edge>[] adj = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++)
			adj[i] = new ArrayList<>();

		for (int i = 1; i <= E; i++)
			// 출발지, 도착지, 가중치 순
			adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));

		// dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		boolean[] check = new boolean[V + 1];
		int[] D = new int[V + 1];

		// start에서 출발
		for (int i = 1; i <= V; i++) {
			if (i == start)
				D[i] = 0;
			else
				D[i] = INF;
		}
		
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			if (check[edge.v])
				continue;

			check[edge.v] = true;

			// next : edge와 연결되어있는 정점
			for (Edge next : adj[edge.v]) {
				if (D[next.v] > D[edge.v] + next.weight) {
					D[next.v] = D[edge.v] + next.weight;
					pq.add(new Edge(next.v, D[next.v]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (D[i] == INF)
				System.out.println("INF");
			else
				System.out.println(D[i]);
		}

	}

}
