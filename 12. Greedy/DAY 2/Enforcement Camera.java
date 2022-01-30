package Week12_Greedy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day2_Enforcement_Camera {
	public static int solution1(int[][] routes) {
		int n = routes.length;
		Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
		
		int answer = 1;
		int out = routes[0][1];
		for(int i = 1 ; i < n ; i++) {
			//겹치는 부분X = 새로 추가 = out 갱신
			if(routes[i][0] > out) { 
				answer++; 
				out = routes[i][1];
			}
			//겹치는 부분O => 두 차의 route에서 제일 마지막 out 비교 
			//1. 뒤차가 out : out 갱신
			//2. 앞차가 out : 그대로 , 변경사항 x
			if(out >= routes[i][1]) out = routes[i][1];
		}

	    return answer;
	}
	public static int solution2(int[][] routes) {
		int n = routes.length;
		Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
		
		Deque<int[]> deque = new ArrayDeque<>();
		for(int i = 0 ; i < n ;i++) {
			if(deque.isEmpty()) deque.add(new int[] { routes[i][0] , routes[i][1] });
			
			if(deque.peekLast()[1] < routes[i][0]) deque.add(new int[] { routes[i][0] , routes[i][1] });
			
			if(deque.peekLast()[1] > routes[i][1]) {
				deque.removeLast();
				deque.add(new int[] { routes[i][0] , routes[i][1] });
			}
		}
		
	    return deque.size();
	}
	public static void main(String[] args) {
		int[][] routes = { {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3} };
		System.out.println(solution1(routes));
		System.out.println(solution2(routes));
	}

}
