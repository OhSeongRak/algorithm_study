package Week4_Stacks_and_Queues;

import java.util.*;

public class Trapping_Rain_Water_JJW {
	public static int trap(int[] height) {
		int len = height.length;
		
		int sum = 0 ; //빗물의 합계
		
		//최대를 찾기 위해서는 어떻게 해야하나?
		//최대에서 마지막에 종료가 되도록 한다
		//양끝에서 시작을 해보자 -> 투포인터

		int l = 0;
		int r = len-1;
		
		int l_max = 0;
		int r_max = 0;
		
		
		while(l < r) {
			l_max = Math.max(height[l], l_max);
			r_max = Math.max(height[r], r_max);
			if(l_max > r_max) {
				sum += r_max - height[r];
				r--;
			}
			else {
				sum += l_max - height[l];
				l++;
			}
		}
		
		
		// 최대 3에서 실패
//		int idx = 0;
//		int max = Integer.MIN_VALUE;
//		while(idx < len) {
//			max = Math.max(height[idx], max);
//			sum += max - height[idx];
//		}
		
		return 	sum;

	
	}
		
    
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		int res = trap(height);
		
		System.out.println(res);
	}

}
