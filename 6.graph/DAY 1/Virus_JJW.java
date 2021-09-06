package Week6_Graph;
import java.util.*;
import java.io.*;

public class Day1_Virus_JJW {
	static int n,m;
	static int worm_cnt = 0;
	
	public static void dfs(ArrayList<ArrayList<Integer>> graph, int depth, boolean[] visited) {
		//재귀로 dfs
		
		visited[depth] = true; 
		
		for(int u : graph.get(depth)) {
			if(visited[u] == false) {
				//정점과 연결된 정점, 아직 방문하지 않았을 때
				worm_cnt++;
				dfs(graph,u,visited);
				
			}
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st ;
		
		
		n = Integer.parseInt(br.readLine());	//정점
		m = Integer.parseInt(br.readLine());	//간선
		
		
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
    	for(int i = 0 ; i < n+1 ; i++) {
    		graph.add(new ArrayList<Integer>());
    	}
    	
    	//System.out.println(graph);

    	boolean[] visited = new boolean[n+1];
    	
    	for(int i = 0 ; i < m; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		//System.out.println(graph);
		
		
		dfs(graph, 1, visited);
		//정점 1부터 virus에 감염되었기 때문
		
		System.out.println(worm_cnt);
		
		
	}
}
