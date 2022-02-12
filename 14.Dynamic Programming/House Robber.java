package Week14_Dynamic_Programming;

import java.util.Arrays;
import java.util.OptionalInt;

public class Day1_House_Robber {
    public static int Wrongrob(int[] nums) {
    	int[] dp = new int[nums.length];
    	for(int i = 0 ; i < nums.length ; i++) {
    		dp[i] = nums[i];
    		for(int j = 0 ; j < i-1 ; j++) {
    			dp[i] = Math.max(dp[i], dp[j]+nums[i]);
    		}
    	}
    	int answer = Arrays.stream(dp).max().getAsInt();
//    	for(int d: dp) System.out.print(d+" ");
    	return answer;
    }
    public static int rob(int[] nums) {
    	int[] dp = new int[nums.length];
    	
    	if(nums.length == 1) return nums[0];
    	dp[0] = nums[0];
    	dp[1] = Math.max(dp[0], nums[1]);
    	
    	for(int i = 2 ; i < nums.length ; i++) {
    		dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
    	}
    	
    	int answer =dp[dp.length-1];
    	for(int d: dp) System.out.print(d+" ");
    	System.out.println();
    	return answer;
    }
	public static void main(String[] args) {
		int[] nums = { 1,2,3,1 };
//		int[] nums = {2,7,9,3,1};
//		int[] nums = { 2,1,1,2};
		System.out.println(rob(nums));
		

	}

}
