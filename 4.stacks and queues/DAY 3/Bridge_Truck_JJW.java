package Week4_Stacks_and_Queues;

import java.util.*;
import java.io.*;

public class Bridge_Truck_JJW {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        
		int cur_time = 0; //경과시간
        int truck_cnt = 0; //다리 위 트럭 수
        int truck_weight = 0; // 다리 위 트럭 무게
        
        //7 4 5 6
        Queue<Integer> queue = new LinkedList<>(); //다리 위
        
        
        //limit : 
        //1. the count 
        //2. the weights / of the truck above the bridge 
                       
        for(int truck : truck_weights) {
        	while(true) {
        		
        		if(queue.isEmpty()) {
        			//큐가 비어있을 경우 
        			
        			queue.add(truck);
            		cur_time++;
            		truck_cnt++;
            		truck_weight += truck;

//    				System.out.println(queue);
//    				System.out.println("cur_time : "+cur_time);
//            		System.out.println("truck_cnt : "+truck_cnt);
//            		System.out.println("truck_weight : "+truck_weight);
            		break;
            		//큐에 truck추가 , 경과시간 증가, 트럭 수 증가, 트럭 무게 추가
            		//7
            		
            		
        		}
        		
        		
        		else if(truck_cnt < bridge_length) {
        			//다리 위 트럭 수가 제한 트럭 수보다 작을 때 -> 추가 가능한지 검사
        			if(truck_weight + truck <= weight) {
        				//가능하다면(현재 다리 위의 트럭 무게 + 뒤의 트럭 무게 < 제한 트럭 무게)

            			queue.add(truck);
        				cur_time++;
        				truck_cnt++;
        				truck_weight += truck;
//        				System.out.println(queue);
//        				System.out.println("cur_time : "+cur_time);
//                		System.out.println("truck_cnt : "+truck_cnt);
//                		System.out.println("truck_weight : "+truck_weight);
        				break;
        				//뒤의 트럭 추가, 경과시간 증가, 트럭 수 증가, 트럭 무게 추가
        				
        			}
        			else {
        				//그렇지 않다면

            			queue.add(0);
        				cur_time++;
        				truck_cnt++;

        				
        				// 의미 없는 0을 추가, 경과시간 증가, 
        				// 7  0
        				
        			}
        			
        		}
        		else if(truck_cnt == bridge_length){
        			//다리 위의 트럭 수가 제한 트럭 수와 같다면
        			
        			truck_weight -= queue.peek();
        			queue.poll();
        			truck_cnt--;

    			
        			// 트럭 무게 감소, 트럭 패스, 트럭 수 감소
        			
        		}
        		
        		
//        		System.out.println(queue);
//        		System.out.println("cur_time : "+cur_time);
//        		System.out.println("truck_cnt : "+truck_cnt);
//        		System.out.println("truck_weight : "+truck_weight);
        	}
        	
        	
        	
        	
        }
        
        return cur_time + bridge_length;
        //for문을 truck_weights만큼 돈 만큼의 cur_time과 brideg_length(다리 길이만큼의 초과 시간)의 합계를 return
        
    }
	public static void main(String[] args) {
		
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		int res = solution(bridge_length, weight,  truck_weights);
		
		System.out.println(res);
	}

}
