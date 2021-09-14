package Week6_Graph;

import java.io.*;
import java.util.*;

public class Day4_Shortest_Route_JJW {
	static int V,E,K, u,v,w;
	static int INF = 1000000;
	
	static List<Edge>[] adj;
	static boolean[] visited;
	static int[] distance;
	
	static class Edge implements Comparable<Edge>{
		int v, w;
		public Edge(int v, int w) {
			this.v = v; // end
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken()); //정점의 개수
		E = Integer.parseInt(st.nextToken()); //간선의 개수
		
		K = Integer.parseInt(br.readLine()); //시작 정점의 번호
		

		adj = new ArrayList[V+1];
		
		for(int i = 0 ; i < V+1; i++) {
			adj[i] = new ArrayList<>();	
		}
		
		visited = new boolean[V+1];
		distance = new int[V+1];
		
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Edge(v,w));
		}
		
		
		
		
		dijkstra(K);
		
		
		print();
		
		
	}
	public static void dijkstra(int K) {
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		Arrays.fill(distance, INF); //INF로 초기화
		
		pq.add(new Edge(K,0)); //시작점 먼저 투입
		
		distance[K] = 0;
		
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int vertex = edge.v; //시작점과 연결된 끝점
			int weight = edge.w;
			
			//System.out.println("vertex : "+vertex + " weight : "+weight);
			if(visited[vertex] == true) continue;
			else visited[vertex] = true;
			
			for(Edge end : adj[vertex]) {
				//System.out.println("end : "+ end.v + " , "+ end.w);
				if(distance[end.v] >= weight + end.w){
					distance[end.v] = weight + end.w ;
					pq.add(new Edge(end.v, distance[end.v]));
				}
			}
		}
		
		
	}
	public static void print() {
		for(int i = 1; i < V+1 ; i++) {
			if(distance[i] == INF) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
}
