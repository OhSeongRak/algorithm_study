package Week6_Graph;

import java.util.*;
	
public class Day2_Furthest_Node_JJW {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	
	public static int solution(int n, int[][] edge) {
		
		visited = new boolean[n+1];
		
		for(int i = 0 ; i <= n ;i++) {
			graph.add(new ArrayList<>());
		}
		
		
		for(int i = 0 ; i < edge.length ; i++) {
			int u = edge[i][0];
			int v = edge[i][1];
			
			graph.get(u).add(v);
			graph.get(v).add(u);
			
		}
	

		//System.out.println(graph);
		
		return bfs(1);
		//dfs(1);
		
		//1 3 2 6 4 5 
		
		
	}
	public static int bfs(int depth) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(depth);
		visited[depth] = true;
		
		int count = 0;
		
		while(true) {
			
			Queue<Integer> farthest = new LinkedList<>();
			//farthest 초기화
			
			while(queue.size() > 0) {
				
				int v = queue.poll();
				//System.out.println("v: " +v);
				for(int u : graph.get(v)) {
					if(visited[u] == false) {
						//System.out.println("u: "+u);
						farthest.add(u);
						visited[u] = true;
							
					}
				}
				
			}
			//farthest : 층마다의 수들의 집합
			//System.out.println("farthest :" +farthest);
			
			if(farthest.size() == 0) break; //더이상의 수가 없다면 종료
			
			queue.addAll(farthest); //층마다 모인 수들을 몽땅 queue에 넣어줌
			count = farthest.size(); //층마다의 수들의 개수
			//System.out.println("queue :"+queue);
			//System.out.println("count: "+count);
		}
		return count;
			
	}

	public static void main(String[] args) {
		
		int n = 6;
		int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
		
		System.out.print(solution(n, edge));
		
	}

}
