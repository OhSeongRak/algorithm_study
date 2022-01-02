package Week8_Heap_and_Priority_Queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day3_Dual_Priority_Queue {
	public static int[] solution(String[] operations) {

  
        PriorityQueue<Integer> heap = new PriorityQueue<>();//오름차순
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
//        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        for(int i = 0 ; i < operations.length ; i++) {
        	String[] st = operations[i].split(" "); //연산만 먼져 뽑아냄
        	switch(st[0]) {
        		case "I" :
        			int num = Integer.parseInt(st[1]);
        			//오름차순과 내림차순의 힙에 모두 추가
        			heap.offer(num);
        			max.offer(num);
        			break;
        		case "D" :
        			if(!heap.isEmpty() && !max.isEmpty()) {
        				if("1".equals(st[1])) {//최대값 삭제
        					//Because we have to know what is the biggest value,
        					// we get the one from max heap
        					// and then, remove one from heap
            				int max_value = max.poll();
            				heap.remove(max_value);
            			}
            			else {//최솟값 삭제
            				// Vice versa
            				int min_value = heap.poll();
            				max.remove(min_value);

            			}

        			}
        			 break;
        		
        		default:
        			break;
        	}
//        	System.out.println("heap: "+heap);
//        	System.out.println("max: "+max);
        }
        int[] answer = new int[2];
        
        
        if(heap.isEmpty()) {
        	answer[0] = 0;
        	answer[1] = 0;
        }
        else {
        	answer[0] = max.peek();
        	answer[1] = heap.peek();
        }
        
        return answer;
    }
	public static void main(String[] args) {
		
//		String[] operations = { "I 7" , "I 5", "I -5", "D -1" };
		String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
		
		int[] answer = solution(operations);
		for(int res : answer) System.out.print(res +" ");
		
		
		 
	}
	
}


