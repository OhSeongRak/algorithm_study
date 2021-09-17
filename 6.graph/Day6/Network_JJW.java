import java.util.*;

class Solution {
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		
		boolean[] visited = new boolean[computers.length];
		
		
		for(int i = 0 ; i < n ; i++) {
			if(visited[i] == false) {
				answer++;
				bfs(i,n,computers,visited);
				//dfs(i, n, computers,visited);
			}
		}

		
		return answer;
		
	}
  //dfs
	public static void dfs(int depth, int n, int[][] computers, boolean[] visited) {
		visited[depth] = true;
		for(int i = 0 ; i < computers.length  ; i++) {
			if(visited[i] == false && computers[depth][i] == 1) {
				dfs(i, n, computers,visited);
			}
		}
	}
	//bfs
	public static void bfs(int depth, int n, int[][] computers, boolean[] visited) {
		
		visited[depth] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(depth);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int i = 0 ; i < computers.length ; i++) {
				if(computers[num][i] == 1 && visited[i] == false) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
			
	}
}
