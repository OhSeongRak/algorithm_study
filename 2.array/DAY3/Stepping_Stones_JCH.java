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
        
        for(int i = 0; i < stones.length; i++) {	//stones �߰��� ã��
        	min = Math.min(min, stones[i]);
        	max = Math.max(max, stones[i]);
        }
        
   
        	
       while(min <= max) {	//max ���� min�� ���������� while ����
    	   mid = (min + max) / 2; 	//mid�� ��� �ʱ�ȭ
    	   cnt = 0;		//cnt�� zeronum�� while�� �������� 0���� �ʱ�ȭ
    	   zeronum = 0;
    	   for(int i = 0 ; i < stones.length ; i++) {
    		   if(stones[i] >= mid) {	// ������ ���� mid ���� Ŭ�� �ǳμ����� ¡�˴ٸ� count �ʱ�ȭ
    			   cnt = 0;
    		   }
    		   else {	//������ ���� mid���� ���� �� �ǳ� �� ���� ¡�˴ٸ� count ����
    			   cnt++;
    			   zeronum = Math.max(zeronum, cnt);	//for���� ���ư��� ���� cnt �� ��� �ٲ� ���� ¡�˴ٸ� count�� �׵��� �ִ밪
    			 
    		   }
    	   }
    	   if(zeronum >= k) {	// ���ǳʴ� ¡�˴ٸ� count�� k���� Ŭ�� max���� mid -1 �� ����
    		   max = mid -1;
    	   }
    	   else {	//���ǳʴ� ¡�˴ٸ� count�� k���� ������ min���� mid +1 �� ����
    		   answer = Math.max(answer, mid);	//mid�� ������ while���� ���鼭 ���亸�� �۾����Ƿ� ��Ȯ�� �´� ���� ã�� ���� k���� ���� ����� �ִ��� answer�� ����
    		   min = mid + 1;
    	   }
    	   
       }
    
      
        
        
        
        
        /*for(int i = 0; i < stones.length; i++) {	//stones �ּڰ� ã��	//ȿ�����˻� ���� �ڵ�
        	min = Math.min(min, stones[i]);
        }
        
        answer += min;
        
        while(true) {
        	if(flag==false) break;
        	cnt = 0;
        	for(int i = 0; i < stones.length; i++) {
        		if(min == stones[i]) {			//min �� ���� ���� ������ cnt �� ����
        			cnt++;
        		}
        		else if(stones[i] > min) {	//min ���� ���氪�� ũ�Ƿ� cnt 0���� �ʱ�ȭ, ���� �� ����
        			flag = true;
        			cnt = 0;
        			stones[i]--;
        			
        		}
        		if(cnt == k) {	//cnt�� k�� �������� ¡�˴ٸ� �ǳμ� ���� break
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
