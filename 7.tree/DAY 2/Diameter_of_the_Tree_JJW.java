package Week7_Tree;

import java.util.*;
import java.io.*;
class Edge {

	int child, weight;
	Edge(int child, int weight){
		this.child = child;
		this.weight = weight;
		
	}
	
	
}
public class Day2_Diameter_of_the_Tree_JJW {
	public static int n,max_idx,max = Integer.MIN_VALUE;
	public static ArrayList<Edge> tree[];
	public static int[] dist;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[n+1];
		
		for(int i = 0; i <= n ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < n-1 ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int children = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree[parent].add(new Edge(children, weight));
			tree[children].add(new Edge(parent, weight));
		}
		
		visited = new boolean[n+1];
		visited[1] = true;
		dfs(1,0);
		//dfs를 통해 먼저 같이 높은 max weight를 찾음
		//System.out.println("max_idx : "+max_idx + "max_weight : " + max);
		
		//root 에서 가장 먼곳인 max_idx부터 다시 dfs 해서 max값 찾기
		visited = new boolean[n+1];
		visited[max_idx]= true;
		dfs(max_idx, 0);
		
		System.out.println(max);
		
	}
	public static void dfs(int child, int weight) {
		
		if(max < weight) {
			max = weight;
			max_idx = child;
		}
		
		for(Edge e : tree[child]){
			if(!visited[e.child]) {
				visited[e.child] = true;
				int newweight = weight+e.weight;
				//System.out.println("dfs ("+e.child+", "+ weight+"+"+e.weight+"= "+newweight+")");
				dfs(e.child, weight + e.weight);
				
			}
		}
		
	}
}

