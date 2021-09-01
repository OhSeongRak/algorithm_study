package Week5_HashTable;

import java.util.Hashtable;

public class Day2_Camouflage_JJW {
	public static int solution(String[][] clothes) {
        int answer = 1;
        
        Hashtable<String, Integer> ht = new Hashtable<>();
        
        int n = clothes.length;
        //종류의 갯수만 필요 , 의상 이름은 필요 없다!
        
        for(int i = 0 ; i < n ;i++) {
        	ht.put(clothes[i][1], ht.getOrDefault(clothes[i][1],0)+1);
        }
        //System.out.println(ht);
        
        
        for(int val : ht.values()) {
        	answer *= (val+1);
        }
        answer -=1;
        return answer;
        
    }
	public static void main(String[] args) {
		String[][] clothes = 
			{{"crowmask", "face"}, {"bluesunglasses","face"}, {"smoky_makeup","face"}};
			//{{"yellowhat","headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		//의상 종류
		int res = solution(clothes);
		System.out.println(res);
			
	}

}
