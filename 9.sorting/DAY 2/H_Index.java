package Week9_Sorting;

import java.util.Arrays;

public class Day2_H_Index {
	public static int solution(int[] citations) {
		
		int n = citations.length;
		Arrays.sort(citations);
		//오름차순
		//0 1 3 5 6
		// 배열  n-i
		// 0    5
		// 1    4
		// 3    3
		// 4    2
		
		// 1 2 3 10 11 12 13
		for(int i = 0 ; i < n ; i++) {
			System.out.println(citations[i] + " , " + (n-i));
			if(citations[i] >= n-i) {
				//citations[i]번 이상 인용된 논문의 개수 = n-i 이상
				//h번 이상 인용된 논문이 h편이상
				return n-i;
			}
		}
		
		return 0;
		
	}
	public static void main(String[] args) {
		int[] citations = { 1, 2, 3, 10, 11, 12, 13};
		
		System.out.println(solution(citations));
	}
}
