package Week11_Sliding_Window;
//https://soongjamm.tistory.com/127?category=1062731 참고
import java.util.Arrays;
import java.util.HashMap;

public class Day1_Jewerly_Shopping {
	public static int[] solution(String[] gems) {
	    int[] answer = new int[2];
	    
	    int start = 0, end = 0;
	    int min_len = Integer.MAX_VALUE;
	    int min_idx = Integer.MAX_VALUE;
	    int n = gems.length;
	    
	    //getOrDefault :key값이 없다면 입력시 설정한 default값 반환
	    //putIfAbsent : key 값이 없다면 입력된 key와 value 입력, 해당 key가 존재하면 입력되었던 값 반환
	    //computeIfPresent :기존의 값 다시 계산
	    
	    HashMap<String, Integer> hm = new HashMap<>(); //보석 이름 , 갯수
	    
	    for(int i = 0 ; i < n ; i++) {
	    	hm.put(gems[i], hm.getOrDefault(gems[i], 0)+1);	
	    }//보석의 갯수를 알아내기 위함
	    int count = hm.size(); // 4
	    
	    hm.clear(); 
	    
	    while(true) {
	    	if(count <= hm.size()) {
//	    		hm.put(gems[start], hm.get(gems[start])-1);
//	    		start++;
	    		hm.computeIfPresent(gems[start++], 
	    				(s, integer) -> (integer-1) == 0 ? null : integer-1);
	    		//value 값을 줄여주는데 0이하이면 null
	    		
	    	}
	    	else if ( end == n) break;
	    	else {
	    		//존재하지 않는다면 넣어줌
//	    		if(!hm.containsKey(gems[end])) hm.put(gems[end],0);
//	    		else {
//	    			hm.put(gems[end], hm.get(gems[end]+1));
//	    			end++;
//	    		}	
	    		
	    		hm.putIfAbsent(gems[end], 0); 
//	    		//존재한다면 1해줌
	    		hm.computeIfPresent(gems[end++], (s, integer) -> integer+1 );
	    	}

	    	//end가 +1된 상태
	    	if(hm.size() == count) {
	    		//사이즈가 같아졌다면 종료해도될 조건이 성립됨 -> min len를 찾아야 함
//	    		System.out.println("start : " +start + ", end : " + end + ", "+gems[end] + ", size : " + hm.size() + " => " +hm);
			    
	    		if( end - start < min_len ||  start < min_idx ) {
//	    			System.out.println("사이즈가 같아짐 => start : "+start + ", end : "+end);
	    			min_len = end - start;
	    			min_idx= start;
	    		}
	    	}
	    }
//	    System.out.println(min_len + " , " + min_idx);
	    //인덱스 상으로는 end는 +1된 상태이고 start는 그대로
	    //문제에서는 인덱스+1이므로 end는 그대로 start는 +1된 상태로 변환
	    answer[0] = min_idx+1;
	    answer[1] = min_idx+min_len;
	    return answer;
	}
	public static void main(String[] args) {
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		System.out.println(Arrays.toString(solution(gems)));
	}

}
