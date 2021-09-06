package Week6_Graph;
import java.util.*;

public class Day1_Valid_Path_JJW {
	
    public static boolean validPath(int n, int[][] edges, int start, int end) {
    	HashMap<Integer, List<Integer>> graph = new HashMap<>();
    	
    	for(int i = 0 ; i < n ; i++) {
    		graph.put(i, new ArrayList<Integer>());
    	}

    	
        for(int i = 0 ; i < edges.length ; i++) {
        	int u = edges[i][0];
        	int v = edges[i][1];
        	graph.get(u).add(v);
        	graph.get(v).add(u);
        	
        }
        
        System.out.println(graph);
    	
        boolean[] visited = new boolean[n];
        
        dfs(graph, start, visited);
        
        if( visited[end] == false) return false;
        
        return true;
        
    }
    public static void dfs(HashMap<Integer, List<Integer>> graph, int start, boolean[] visited) {
		
		visited[start] = true;
		
		for(int u : graph.get(start)) {
			if(visited[u] == false) dfs(graph, u, visited);
		}
		
		
	}
	public static void main(String[] args) {
		int n = 6;
		int[][] edges = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
		int start = 0;
		int end =5;
		
		boolean res = validPath(n, edges, start, end);
		System.out.println(res);
	}

}
