import java.util.Queue;
import java.util.LinkedList;

class Bridge_Truck_KJY {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		int sumWeight = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0 ; i< bridge_length;i++)
			queue.add(0);
		
		for (int index = 0; index < truck_weights.length; index++) {
			// new truck is over bridgeWeight
			if (sumWeight + truck_weights[index] > weight) {
				while(sumWeight + truck_weights[index]-queue.peek() > weight) {
					time++;
					sumWeight -=queue.poll();
					queue.add(0);
				}
				time++;
			}
			// new truck is less bridegeWeight
			else {
				time++;
			}
			sumWeight -= queue.poll();
			queue.add(truck_weights[index]);
			sumWeight += truck_weights[index];
		}
		
		while( !queue.isEmpty()) {
			time++;
			queue.poll();
		}

		return time;
	}
	public static void main(String[] args) {
		int[] bridege_length= {1,1,4,3,3,5,7,5,5};
		int[] weight = {2,1,2,3,1,5,7,5,5};
		int[][] truck_weights= {
				{1,1,1},
				{1,1,1},
				{1,1,1,1},
				{1,1,1},
				{1,1,1},
				{1,1,1,1,1,2,2},
				{1,1,1,1,1,3,3},
				{1,1,1,1,1,2,2,2,2},
				{2, 2, 2, 2, 1, 1, 1, 1, 1}
		};
		
		for ( int i = 0 ; i < 9 ; i++) {
			System.out.println(solution(bridege_length[i],weight[i],truck_weights[i]));
		}
		

	//1	2	[1, 1, 1]	4
	//1	1	[1, 1, 1]	4
	//4	2	[1, 1, 1, 1]	10
	//3	3	[1, 1, 1]	6
	//3	1	[1, 1, 1]	10
	//5	5	[1, 1, 1, 1, 1, 2, 2]	14
	//7	7	[1, 1, 1, 1, 1, 3, 3]	18
	//5	5	[1, 1, 1, 1, 1, 2, 2, 2, 2]	19
	//5	5	[2, 2, 2, 2, 1, 1, 1, 1, 1]	19
	}
	
}
