package Week8_Heap_and_Priority_Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Day2_Disk_Controller {
	 public static int solution(int[][] jobs) {
	       int now = 0; // current time
			int count = 0; // the # of completed work
			int waiting = 0; // waiting time
			
			// 0 1 2 3 -> 3 - 0 = 3
			//     2 3 4 5 6 7   -> 3 + (6 - 2) =7
			//   1 2 3 4 5 6 7 8 9 -> 3 + 6 + (9 - 1) = 17
						
			//Sorted by starting time -> 현재 시간과 비교하며
			Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0] ));
			
			
			//Sorted by working time -> 대기하고 있는 디스크 중 작업시간이 작은 것
			PriorityQueue<int[]> heap = new PriorityQueue<>(((o1,o2) ->  o1[1] - o2[1]));
			
			
			int i = 0;
			
			while(count < jobs.length) {	
				while(i < jobs.length && now >= jobs[i][0]) {
					heap.add(jobs[i]);
					i++;
				}
				//starting time으로 sort되어있는 배열 jobs 을 돌면서 now 현재시간보다 작다면 heap에 추가 
				
				if(!heap.isEmpty()) {
					int[] work = heap.poll();
					waiting += now - work[0] + work[1];
					
//					System.out.println("now : "+now);
//					System.out.println(work[0] + " " +work[1]);
//					System.out.println("waiting : " + waiting);
//					System.out.println();
					
					now += work[1];
					count++;
				}
				else {
					now++;
					//현재 대기 중인 디스크가 없다면 now를 증가시키며 디스크가 작업할 시간 때가지 기다림
				}
				
			}
			
		    return waiting/count;
		}
	
	public static void main(String[] args) {
//		int[][] jobs = { {0,3}, {1,9}, {2,6} };
		int[][] jobs = { {0,10}, {4,10}, {5,11}, {15,2} };
		System.out.println(solution(jobs));
		
	}

}
