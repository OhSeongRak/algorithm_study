package Week5_HashTable;

import java.util.*;
import java.io.*;

public class Day3_First_Missing_Positive_JJW {

	public static int firstMissingPositive(int[] nums) {
		int res = 0;
		
		Hashtable<Integer, Integer> hs = new Hashtable<>();
		
		Arrays.sort(nums);
		
		for(int val : nums) {
			if(val > 0) {
				hs.put(val, hs.getOrDefault(val, 0)+1);
			}
		}
		//System.out.println(hs);
		
		int index = 1;
		
		while(true) {
			//System.out.println("index : " + index);
			if(hs.containsKey(index)) {
				index++;
				
			}
			else {
				res = index;
				break;
			}
		}
		
		return res;
		
	}
	public static void main(String[] args) {
		
		//int[] nums = {3, 4, -1, 1};
		int[] nums = {7,8,9,11,12};
		
		int res = firstMissingPositive(nums);
		System.out.println(res);
	}

}
