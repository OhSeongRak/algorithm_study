import java.util.Arrays;
import java.util.Hashtable;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        Hashtable<String,Integer> ht = new Hashtable<>();
        
        ht.put(phone_book[0],phone_book[0].length());
        
        for (int pBIdx = 1 ; pBIdx<phone_book.length;pBIdx++) {
        	for(int pBIdx2 = 1 ; pBIdx2 <= phone_book[pBIdx].length() ;pBIdx2++) {
        		String tmp = phone_book[pBIdx].substring(0,pBIdx2);
        		if(ht.containsKey(tmp)) {
        			return false;
        		}
        	}
        	ht.put(phone_book[pBIdx],phone_book[pBIdx].length());
        }
        
        
        
        
        return answer;
    }
}
