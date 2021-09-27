
class Solution {
	
	public void DFS(int n ,int[][] computers,boolean[] visited,int visit){
		visited[visit] = true;
		for( int i = 1; i <= n ; i++) {
			if(computers[visit-1][i-1] == 1 && visited[i] == false) {
				DFS(n,computers,visited,i);
			}
		}
	}
	
	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n+1];
		for (int computerNum = 1; computerNum <= n; computerNum++) {
			if(visited[computerNum] == false) {
				answer++;
				DFS(n, computers, visited, computerNum);
			}
		}
        
        
        
        return answer;
    }
}
