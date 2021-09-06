import java.util.*;

class Solution {
	
	class Graph{
		ArrayList<ArrayList<Integer>> graph;
		boolean[] visited;
    	
		Graph(int num){
			 this.graph= new ArrayList<ArrayList<Integer>>();
			 for(int i = 0 ; i < num ; i++) {
				 ArrayList<Integer> tmp = new ArrayList<>();
				 tmp.add(i);
				 graph.add(tmp);
			 }
			 this.visited = new boolean[num];
		}
		void add(int num1,int num2) {
			this.graph.get(num1).add(num2);
    		this.graph.get(num2).add(num1);
		}
	}
	
    public boolean validPath(int n, int[][] edges, int start, int end) {
    	
    	Graph gp= new Graph(n);
    	
    	for ( int index = 0 ; index< edges.length ;index++) {
    		gp.add(edges[index][0], edges[index][1]);
    	}
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(start);
    	
    	while(!queue.isEmpty()) {
    		int headTmp = queue.poll();
    		
    		gp.visited[headTmp]=true;
    		
    		for(int NodeTmp : gp.graph.get(headTmp)) {
    			if (NodeTmp == end)
    				return true;
    			if(gp.visited[NodeTmp] == false)
    				queue.add(NodeTmp);
    		}
    	}
    	return false;
    }
}
