package HashTable;

import java.util.Hashtable;

public class unsuccessful_runner_OSR {

	public String solution(String[] participant, String[] completion) {
        String answer = "";
		Hashtable<String, Integer> ct = new Hashtable<>();
		
		for(String str : completion) {
			if(ct.containsKey(str))
				ct.put(str, ct.get(str) + 1);
			else
				ct.put(str, 1);
		}
		
		for(String str : participant) {
			if(ct.containsKey(str)) {
				int cnt = ct.get(str);
				
				if(--cnt == 0)
					ct.remove(str);
				else
					ct.put(str, cnt);
			}
			
			else
				return str;
		}
		
		return "FALSE";
    }

	public static void main(String[] args) {

	}

}
