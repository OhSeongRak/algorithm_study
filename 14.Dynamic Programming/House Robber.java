package Week14_Dynamic_Programming;

import java.util.Arrays;
import java.util.OptionalInt;

public class Day1_House_Robber {
    public static int rob(int[] nums) {
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
	public static void main(String[] args) {
		int[] nums = { 1,2,3,1 };
//		int[] nums = {2,7,9,3,1};
//		int[] nums = { 2,1,1,2};
		System.out.println(rob(nums));
		

	}

}
