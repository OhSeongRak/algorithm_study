package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Bridge_Truck_OSR {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		Deque<Integer> bridge = new ArrayDeque<>();

		int time = 0;		// �ɸ� �ð�
		int truck_cnt = 0;  // �������� Ʈ���� ����
		int cur_weight = 0; // ���� �ٸ��� �ִ� Ʈ�� ���� ��
		int idx = 0;        // truck_weights�� �ε���
		
		// �� ������ ǥ���ϱ� ���� 0���� ä��
		for (int i = 0; i < bridge_length; i++)
			bridge.add(0);

		// �ٸ����� �������� Ʈ���� ������ truck_cnt�� truck_weights�� ���̶� ������ ��� �ݺ��� Ż��.
		while (truck_cnt < truck_weights.length) {

			// �� ���� 0�� �ƴ� ���, truck_cnt�� ����, ���� ���� ���ҽ�Ŵ
			if (bridge.getFirst() != 0) {
				truck_cnt++;
				cur_weight -= bridge.getFirst();
			}

			bridge.pollFirst();
			
			// ���� ���� + ���� Ʈ�� ���԰� weight���� ���� �� Ʈ�� ����, ���� ���� ����
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
