package Week8_Heap_and_Priority_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day1_Task_Scheduler {
	
	public static int leastInterval(char[] tasks, int n) {
		
		int times = 0 ;
		int plus = 0;
		int maxcount = 0;
		
		HashMap<Character, Integer> hm = new HashMap<>();
		int[] count = new int[26];
		
		if(n == 0) return tasks.length;
		
		
		for(int i = 0 ; i < tasks.length; i++) {
	        hm.put(tasks[i], hm.getOrDefault(tasks[i], 0)+1);
	        count[tasks[i]-'A'] ++;
	        if(count[tasks[i]-'A'] == maxcount) {
	        	plus++;
	        }
	        else if(count[tasks[i]-'A'] > maxcount) {
	        	maxcount = count[tasks[i]-'A'];
	        	plus = 1;
	        }
		}
//		for(int i = 0 ; i < count.length ; i++) {
//			System.out.print(count[i] + " ");
//		}
//		System.out.println(hm);
//		Integer maxvalue = Collections.max(hm.values());
//		System.out.println(getKey(hm, maxvalue));
		
		
		times = (maxcount-1) * (n+1)  + plus;
		return (tasks.length > times)? tasks.length : times;
		
		
	   
	}
	
	

	


	public static void main(String[] args) {
	
//		char[] tasks = {'A','A','A','A','A','A','B','C','D', 'E', 'F', 'G'};
//		char[] tasks = {'A','B','C','D','E','A','B','C','D', 'E'};
		char[] tasks = {'A','A','A','B','B','B','C','C','C','D','D','E'};
		
		int n = 2;
		System.out.println(leastInterval(tasks, n));
		
	}

}
