package Week5_HashTable;

import java.util.*;

public class Day1_Unsuccessful_Runner_JJW {
	 public static String solution(String[] participant, String[] completion) {
	        String answer = "";
	        //1. [] -> ""
	        //2. 중복!! -> value값을 다르게 지정 => getorDefault(key, value) : key값이 기존에 있다면 기본값 , 그렇지 않다면 추가적 연산
	        Hashtable<String, Integer> ht = new Hashtable<String,Integer>();
	        
	        for(String str : participant){
	            ht.put(str, ht.getOrDefault(str, 0)+1);
	            
	        }
	        
	       //System.out.println(ht);
	        
	        for(String str : completion) {
	        	if(ht.containsKey(str)) {
	        		if(ht.get(str) != 1) ht.put(str,  ht.get(str)-1);
	        		//ht에서 str을 key로 가지고 있는 value가 1이 아니라면 value값을 감소시켜줌
	        		else ht.remove(str);
	        		//value가 1이라면 과감히 삭제
	        		
	        	}
	        	
	        }
	        
	        //System.out.println(ht);
		       
	        for(String s : ht.keySet()) {
	        	answer = s;
	        }
	       
	        return answer;
	    }
	public static void main(String[] args) {
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		String res = solution(participant, completion);
		System.out.println(res);

	}

}
