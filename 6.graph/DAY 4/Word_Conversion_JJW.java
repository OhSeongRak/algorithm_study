package Week6_Graph;

public class Day4_Word_Conversion_JJW {
	
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
    public static int solution(String begin, String target, String[] words) {
        
    	visited = new boolean[words.length];
    	for(int i=0; i< words.length ;i++) {
    		visited[i] = false;
    	}
    	
        dfs(begin, target, words, 0);
        
        
        return min;
        
    }
    public static void dfs(String begin, String target, String[] words, int depth) {
    	
    	if(begin.equals(target)) {
    		min = Math.min(min, depth);
    		return;
    	}
    	
    	
    	for(int i = 0 ; i < words.length; i++) {
    		if(visited[i]) continue;
    		int cnt = 0; 
    		for(int j = 0 ; j < words[i].length(); j++) {
    			if(words[i].charAt(j) != begin.charAt(j)) {
    				//System.out.println(words[i] + "   "+words[i].charAt(j) + "     " + begin.charAt(j));
    				cnt++;
    			}
    		}
    		if(cnt == 1) {
    			visited[i] = true;
    			dfs(words[i], target, words, depth+1);
    			visited[i] = false;
    		}
    		
    	}
    }
	public static void main(String[] args) {
		
//		String begin = "hit";
//		String target = "cog";
//		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
//		
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot"};
//		
		System.out.println(solution(begin,target,words));
		
	}

}
