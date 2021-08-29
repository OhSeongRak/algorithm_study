package Week5_HashTable;
import java.util.*;

public class Day1_Ransom_Note_JJW {
	public static boolean canConstruct(String ransomNote, String magazine) {
        boolean answer = true;
        //if ransomNote can be constructed from magazine(m -> r) return true
        
        Hashtable<Character, Integer> ht = new Hashtable<Character,Integer>();
        
        for(int i = 0 ; i < magazine.length() ; i++) {
        	char c = magazine.charAt(i);
        	ht.put(c, ht.getOrDefault(c, 0)+1);
        }
        
        for(int i = 0 ; i < ransomNote.length() ; i++) {
        	char c = ransomNote.charAt(i);
        	if(ht.containsKey(c)) {
        		if(ht.get(c) != 1) ht.put(c, ht.get(c)-1);
        		else ht.remove(c);
        	}
        	//포함한다면 value값을 줄여주기
        	else answer = false;
        	//포함하고 있지 않다면 무조건 false
        }
        
        //System.out.println(ht);
        return answer;
    }
	public static void main(String[] args) {
		
		String ransomNote = "aa";
		String magazine = "aab";
		boolean result = canConstruct(ransomNote, magazine);
		System.out.println(result);
	}

}
