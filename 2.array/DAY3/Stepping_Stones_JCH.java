import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int cnt = 0;
        int idx = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int mid;
        int zeronum = 0;
        boolean flag = true;
        
        for(int i = 0; i < stones.length; i++) {	//stones 중간값 찾기
        	min = Math.min(min, stones[i]);
        	max = Math.max(max, stones[i]);
        }
        
   
        	
       while(min <= max) {	//max 보다 min이 작을때까지 while 돌림
    	   mid = (min + max) / 2; 	//mid는 계속 초기화
    	   cnt = 0;		//cnt와 zeronum은 while문 돌때마다 0으로 초기화
    	   zeronum = 0;
    	   for(int i = 0 ; i < stones.length ; i++) {
    		   if(stones[i] >= mid) {	// 스톤의 값이 mid 보다 클때 건널수없는 징검다리 count 초기화
    			   cnt = 0;
    		   }
    		   else {	//스톤의 값이 mid보다 작을 때 건널 수 없는 징검다리 count 증가
    			   cnt++;
    			   zeronum = Math.max(zeronum, cnt);	//for문이 돌아감에 따라 cnt 값 계속 바뀜 최종 징검다리 count는 그들의 최대값
    			 
    		   }
    	   }
    	   if(zeronum >= k) {	// 못건너는 징검다리 count가 k보다 클때 max값을 mid -1 로 설정
    		   max = mid -1;
    	   }
    	   else {	//못건너는 징검다리 count가 k보다 작을때 min값을 mid +1 로 설정
    		   answer = Math.max(answer, mid);	//mid는 마지막 while문을 돌면서 정답보다 작아지므로 정확히 맞는 값을 찾기 위해 k보다 작은 경우의 최댓값을 answer에 저장
    		   min = mid + 1;
    	   }
    	   
       }
    
      
        
        
        
        
        /*for(int i = 0; i < stones.length; i++) {	//stones 최솟값 찾기	//효율성검사 실패 코드
        	min = Math.min(min, stones[i]);
        }
        
        answer += min;
        
        while(true) {
        	if(flag==false) break;
        	cnt = 0;
        	for(int i = 0; i < stones.length; i++) {
        		if(min == stones[i]) {			//min 과 스톤 값이 같으면 cnt 값 증가
        			cnt++;
        		}
        		else if(stones[i] > min) {	//min 보다 스톤값이 크므로 cnt 0으로 초기화, 스톤 값 감소
        			flag = true;
        			cnt = 0;
        			stones[i]--;
        			
        		}
        		if(cnt == k) {	//cnt가 k와 같아지면 징검다리 건널수 없음 break
        			flag = false;
        			break;
        		}
        		
        	}
        	if(flag==true) answer++;
        }*/
        		
        
        return answer;
    }
}
public class Stepping_Stones {

	public static void main(String[] args) {
		int [] stones;
		int a;
		int k;
		int res;
		int n;
		
		Solution s = new Solution();
		
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		stones = new int [n];
		for(int i = 0; i < n; i++) {
			stones[i] = input.nextInt();
		}
		k = input.nextInt();
		
		System.out.println(s.solution(stones, k));
		
	}

}
