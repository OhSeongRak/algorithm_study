package Week14_Dynamic_Programming;

import java.util.Arrays;

public class Day1_Jump_Game {
    public static boolean canJump(int[] nums) {
    	
    	int[] dp = new int[nums.length];
    	int n = nums.length;

    	if(n == 1) return true;

    	dp[0] = nums[0];
    	
    	for(int i = 1 ; i < nums.length-1 ; i++) {
    		if(dp[i-1] < i) return false;
    		dp[i] = Math.max(dp[i-1] , nums[i] + i);
    		
    	}
//    	for(int d : dp) System.out.print(d + " ");
//    	System.out.println();    	
    	return dp[n-2] >= n-1 ? true : false;



        


    }
	public static void main(String[] args) {
		int[] nums = { 2,3,1,1,4 };
//		int[] nums = {3,2,1,0,4};
//		int[] nums = { 2,0,0 };
//		int[] nums = {0,2,3};
		System.out.println(canJump(nums));
		
	}

}
