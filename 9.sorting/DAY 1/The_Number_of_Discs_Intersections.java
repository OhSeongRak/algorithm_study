package Week9_Sorting;

import java.util.Arrays;
import java.util.Collections;

public class Day1_The_Number_of_Discs_Intersections {
	public static int solution(int[] A) {
		int count = 0;
		
		int[][] points = new int[A.length][2];
			
		for(int i = 0 ; i < A.length ; i++){
			points[i][0] = i - A[i];
			points[i][1] = i + A[i];

			//left, right
		}
		
		//  1  5  2  1   5  0
		// -1 -4  0  2  -1  5 
		//  1  6  4  4   9  5
		
		//겹친다 = 원의 중심과의 거리가 각각의 반지름의 합보다 작다
		
		Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
		
		
		
		
		for(int i = 0 ; i < A.length ; i++) {
			for(int j = i+1 ; j < A.length ; j++) {

				if(Math.abs(i-j) <= A[i]+A[j]) count++;
//				else if(points[i][0] <= points[j][0] && points[i][1] >= points[j][1] ) count++;
//				else if( points[i][1] >= points[j][0] && Math.abs(i-j) <= A[i]+A[j] ) count++;
				
			}
		}
		
		return count;
	}
	public static void main(String[] args) {
		int[] A = {1,5,2,1,4,0};
		System.out.println(solution(A));
		
	}

}
