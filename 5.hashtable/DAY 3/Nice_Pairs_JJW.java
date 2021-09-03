package Week5_HashTable;

import java.util.*;

public class Day3_Nice_Pairs_JJW {
	public static int countNicePairs(int[] nums) {
        
        int res = 0;
        
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        
        //nums[i] + reverse(nums[j]) == nums[j] + reverse(nums[i])
        //-> nums[i] - reverse(nums[i]) == nums[j] - reverse(nums[j])
        
        for(int val : nums) {
        	
        	int diff = val - reverse(val);
        	ht.put(diff, ht.getOrDefault(diff, 0)+1);
        	
        }
        //ht.put(val, val-reverse(val));
        System.out.println(ht);
        
    	//{97=18, 42=18, 1=0, 11=0}
    	//{76=9, 10=9, 24=-18, 35=-18, 13=-18}
    	
        for(int val : ht.values()) {
        	res += permutation(val);
        }
        
        int mod = (int)Math.pow(10, 9)+7;
        
        return res % mod;
        
        
        //배열로 푼 이중 for문 -> 런타임에러
//        int count=0;
//        for(int i = 0 ; i < len ; i++) {
//        	for(int j = i+1 ; j < len ; j++) {
//        		if(nums[i] + reverse(nums[j]) == nums[j] + reverse(nums[i])) {
//        			count++;
//        		}
//        	}
//        }
       
       
    }
	public static int permutation(int number) {
		//nP2/2
		return number * (number-1) / 2;
		
	}
	public static int reverse(int number) {
		int rev = 0;
		while(number > 0) {
			rev = rev*10 + number%10;
			number /= 10;
		}
		return rev;
	}
	public static void main(String[] args) {
		
		int[] nums = {42,11,1,97};
		//int[] nums = {13,10,35,24,76};//
		
		int answer = countNicePairs(nums);
		System.out.println(answer);
	}

}
