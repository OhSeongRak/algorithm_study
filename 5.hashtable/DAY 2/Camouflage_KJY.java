import java.util.Hashtable;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Hashtable<String,Integer> ht = new Hashtable<>();
        
        
        for(String[] s : clothes) {
        	ht.put(s[1],ht.getOrDefault(s[1],0)+1);
        }
        
        for(String key : ht.keySet()) {
        	answer *= ht.get(key)+1;
        }

        
        
        
        
        return answer-1;
    }
}
