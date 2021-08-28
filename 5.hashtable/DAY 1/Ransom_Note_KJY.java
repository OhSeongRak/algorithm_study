import java.util.Hashtable;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Hashtable<String,Integer> ht = new Hashtable<>();
        
        for(int mIdx = 0 ; mIdx < magazine.length() ; mIdx++){
        	String s = magazine.substring(mIdx,mIdx+1);
            if(ht.containsKey(s)) {
            	ht.put(s,ht.get(s)+1);
            }
            else
            	ht.put(s,1);
        }
        
        for(int rIdx = 0 ; rIdx< ransomNote.length();rIdx++) {
        	String s = ransomNote.substring(rIdx,rIdx+1);
        	if(ht.containsKey(s)) {
        		int num = ht.get(s);
        		if (num==1)
        			ht.remove(s);
        		else
        			ht.put(s,num-1);
        	}
        	else {
        		return false;
        	}
        }
        return true;
        
    }
}
