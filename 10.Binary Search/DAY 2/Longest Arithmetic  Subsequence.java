package Week10_Binary_Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class Day2_Longest_Arithmetic_subsequence {
	public static int longestArithSeqLength(int[] nums) {

		int max = 0;
		int n = nums.length;
		HashMap<Integer, Integer>[] dp = new HashMap[n];
		//2차원 hashmap 구현
		for(int i = 0 ; i < n ; i++) {
			dp[i] = new HashMap<>();
			for(int j = 0 ; j < i ; j++) {
				int dif = nums[i]-nums[j];
				
//				dp.put(dif, dp.getOrDefault(dif, 0)+1);	
//				--> dp[j]에도 같은 key가 있다면 수 추가
//				key : 차 , value : 차를 갖는 수들의 수
				
				dp[i].put(dif, dp[j].getOrDefault(dif, 1)+1);
				//진행할때마다 max값을 저장
				max = Math.max(max, dp[i].get(dif));
				
//				System.out.println(i+" : " + dp[i]);
//				System.out.println("max : "+max);		
			}
		}
		
		return max;        
    }
	public static void main(String[] args) {
		int[] nums = { 9,4,7,2,10 };
//		int[] nums = { 83, 20, 17, 43, 52, 78, 68, 45 };
//		int[] nums = {20,1,15,3,10,5,8};
		System.out.println(longestArithSeqLength(nums));
	}

}
