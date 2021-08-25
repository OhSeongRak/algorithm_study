package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Bridge_Truck_OSR {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		Deque<Integer> bridge = new ArrayDeque<>();

		int time = 0;		// 걸린 시간
		int truck_cnt = 0;  // 빠져나온 트럭의 개수
		int cur_weight = 0; // 현재 다리에 있는 트럭 무게 합
		int idx = 0;        // truck_weights의 인덱스
		
		// 빈 공간을 표현하기 위해 0으로 채움
		for (int i = 0; i < bridge_length; i++)
			bridge.add(0);

		// 다리에서 빠져나온 트럭의 개수인 truck_cnt가 truck_weights의 길이랑 같아질 경우 반복문 탈출.
		while (truck_cnt < truck_weights.length) {

			// 맨 앞이 0이 아닐 경우, truck_cnt를 증가, 현재 무게 감소시킴
			if (bridge.getFirst() != 0) {
				truck_cnt++;
				cur_weight -= bridge.getFirst();
			}

			bridge.pollFirst();
			
			// 현재 무게 + 들어올 트럭 무게가 weight보다 작을 때 트럭 들어옴, 현재 무게 증가
			if (idx != truck_weights.length && cur_weight + truck_weights[idx] <= weight) {
				bridge.addLast(truck_weights[idx]);
				cur_weight += truck_weights[idx++];
			} else
				bridge.addLast(0);
			
			time++;
		}

		return time;
	}

	public static void main(String[] args) {
		int []truck_weights = {7,4,5,6};
		int bridge_length = 2;
		int weight = 10;
		
		System.out.print(solution(bridge_length, weight, truck_weights));
	}

}
