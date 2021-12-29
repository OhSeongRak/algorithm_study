package Week8_Heap_and_Priority_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Day2_More_Spicy {
	 public static int solution(int[] scoville, int K) {
		 	//스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + 두번째로 맵지 않은 음식의 스코빌 지수 *2
	        
	        int answer = 0;
	        
	        //List
	        boolean flag = true;
	        List<Integer> l = new ArrayList<>();
	        for(int val : scoville) 
	        	l.add(val);
	       
	        while(flag) {
	        	Collections.sort(l);
	        	//System.out.println(l);
	        	int new_scov = l.get(0) + l.get(1)*2;
	        	l.remove(l.get(0));
	        	l.remove(l.get(0));
	        	l.add(new_scov);
	        	System.out.println(l);
	        	answer++;
	        	int count = 0;
	        	for(int val : l) {
	        		if(val > K) count++;
	 			}
	        	if(count == l.size()) flag = false;   	
	        }
	        
	        //PriorityQueue
	        PriorityQueue<Integer> heap = new PriorityQueue<>();
	        for(int SHU : scoville)
	        	heap.add(SHU);
	        
	        while(heap.peek() < K) {
	        	System.out.println(heap);
	        	if(heap.size() < 2) return -1;
	        	//-> Runtime Error : When the size of heap is smaller than 2 , it cannot be producted below calcaulate
	        	int new_scov = heap.poll() + heap.poll()*2;
	        	heap.add(new_scov);
	        	answer++;
	        	
	        }
	        return answer;
	    }
	public static void main(String[] args) {
		
		int[] scoville = { 1,2,3,9,10,12 };
		int k = 7;
		System.out.println(solution(scoville, k));

	}

}
