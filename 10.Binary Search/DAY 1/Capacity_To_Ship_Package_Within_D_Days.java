package Week10_Binary_Search;

import java.util.Arrays;

public class Day1_Capacity_To_Ship_Package_Within_D_Days {
	public static int shipWithinDays(int[] weights, int days) {
		
		int start = Integer.MAX_VALUE;
		int end = 0;
		int max = Integer.MIN_VALUE;
		
		
		for(int w : weights) {
			end += w;
			if ( start > w) start = w;
			
		}
		System.out.println(start+", "+end);
//		while(start <= end) {
//			int mid = (start + end)/ 2;
//			if(possible(mid, days, weights)) end = mid-1;
//			else start = mid+1;
//		}
		while(start < end) {
			int mid = (start + end)/ 2;
			if(possible(mid, days, weights)) end = mid;
			else start = mid+1;
		}
		return start;
	}
	public static boolean possible(int capacity, int days, int[] weights) {
		int ship_sum = 0;
		int pck_cnt = 1;
		
		for(int w : weights) {
			if(ship_sum + w > capacity) {
				ship_sum = w;
				pck_cnt++;
			}
			else ship_sum += w;
			
			if(pck_cnt > days) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] weights = {1,2,3,1,1};
		int days = 4;
		
		System.out.println(shipWithinDays(weights, days));
			
	}

}
