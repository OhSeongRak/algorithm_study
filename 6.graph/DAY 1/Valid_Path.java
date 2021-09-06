//Queue 가 신기해서 가져와봄


class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        ArrayList<ArrayList<Integer>> vtces = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	vtces.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
        	int x = edges[i][0];
        	int y = edges[i][1];
        	
        	vtces.get(x).add(y);
        	vtces.get(y).add(x);
        }
        
        boolean[] visited = new boolean[n];
      
        Queue<Integer> que = new PriorityQueue<>();
      
        que.add(start);
      
        while(que.size() > 0) {
        	int rem = que.remove();
        	
          if(rem == end)
        		return true;
          
        	for(int i = 0; i < vtces.get(rem).size(); i++) {
            
        		if(visited[vtces.get(rem).get(i)] == false) {
              //방문하지 않았다면 방문했다고 변경해주고
        			visited[vtces.get(rem).get(i)] = true;
        			que.add(vtces.get(rem).get(i));
              //막 방문한 정점을 queue에 추가하는 방식
        		}
        	}
        } 
        
        return false;
    }
}
