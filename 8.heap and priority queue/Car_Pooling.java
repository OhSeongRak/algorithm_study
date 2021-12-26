package Week8_Heap_and_Priority_Queue;


import java.util.Arrays;


public class Day1_Car_Pooling {
	 public static boolean carPooling(int[][] trips, int capacity) {
		 
		 //도착지를 기준으로 오름차순 정렬 -> 마지막 도착지로 path의 length를 구하기 위해
		 Arrays.sort(trips, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		 int maxvalue = trips[trips.length-1][2];
		 int[] path = new int[maxvalue+1];
		
		 
		 //출발지를 기준으로 오름차순 정렬
		 Arrays.sort(trips, (o1, o2) -> Integer.compare(o1[1], o2[1]));
		 
	
		 for(int i = 0 ; i < trips.length ; i++) {	
			 path[trips[i][1]] += trips[i][0];
			 path[trips[i][2]] += -trips[i][0];
		 }
		 
		 for(int i = 1 ; i < path.length; i++) {
			 path[i] = path[i-1] + path[i];
		 }

		 
		 for(int p : path) {
			 if(p > capacity || p < 0) return false;
		 }
	     return true;
	        
	}
	public static void main(String[] args) {
		int[][] trips = { {9,3,4}, {9,1,7}, {4,2,4}, {7,4,5} };
//		int[][] trips = { {3,2,7}, {3,7,9}, {8,3,9} };
		
		int capacity = 23;
		System.out.println(carPooling(trips, capacity));

	}

}
