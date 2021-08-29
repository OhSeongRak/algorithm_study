package Week5_HashTable;
import java.util.*;

public class Day1_Phone_Book_JJW {
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		
		Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
		
		Arrays.sort(phone_book);
		
		String prefix = phone_book[0];
		int prefix_len = phone_book[0].length();
		
		ht.put(prefix, prefix_len);
		//접두어 -> 작은 거를 담아야해 -> 정렬 -> 제일 처음 꺼만 ht에 담아
		// 여기서 의문 ? -> 다음 접두어가 생길 수 있음 -> while문 
    //System.out.println(ht);
		
		for(int i = 1 ; i < phone_book.length ; i++) {
			//System.out.println(phone_book[i]);
			for(int j = 0 ; j <=  phone_book[i].length()-prefix_len ; j++) {
				if(ht.containsKey(phone_book[i].substring(j, j+prefix_len))) {
					//System.out.println(phone_book[i].substring(j, j+prefix_len));
					//substring으로 prefix 의 길이만큼 쪼개어 비교
					answer = false;
					break;
				}
			}
		}
		
		
		return answer;
	}
	public static void main(String[] args) {
		String[] phone_book = {"12", "123", "1235", "567", "88"};
		boolean res = solution(phone_book);
		System.out.println(res);
	}

}
