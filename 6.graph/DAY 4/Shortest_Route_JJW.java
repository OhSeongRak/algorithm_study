class Solution {
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
    public static int solution(String begin, String target, String[] words) {
        
    	visited = new boolean[words.length];
    	
        dfs(begin, target, words, 0);
        
        if(min == Integer.MAX_VALUE) min = 0;
        return min;
        
    }
    public static void dfs(String begin, String target, String[] words, int depth) {
    	
    	if(begin.equals(target)) {
    		min = Math.min(min, depth);
    	}
        
    	
    	for(int i = 0 ; i < words.length; i++) {
    		if(visited[i]) continue;
    		int cnt = 0; 
    		for(int j = 0 ; j < words[i].length(); j++) {
    			if(words[i].charAt(j) == begin.charAt(j)) {
    				//System.out.println(words[i] + "   "+words[i].charAt(j) + "     " + begin.charAt(j));
    				cnt++;
    			}
    		}
    		if(cnt == words[i].length()-1) {
    			visited[i] = true;
    			dfs(words[i], target, words, depth+1);
    			
    		}
    		
    	}
    }
}
