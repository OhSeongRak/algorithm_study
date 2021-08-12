package Array;

import java.util.Arrays;

public class Stepping_Stones_OSR {

	public static int solution(int[] stones, int k) {
//        int N = 0;
//        
//        while(true) {
//        	int s = -1, e = 0;
//        	while(e < stones.length) {
//        		if(stones[e] != 0) {
//        			stones[e]--;
//        			s = e++;
//        		}
//        		else
//        			e++;
//        		
//        		if(e - s > k)
//                	return N;
//        	}
//        	N++;
//        }

		int left = 0;
		int right = Arrays.stream(stones).max().getAsInt();
		int answer = 0;

		while (left <= right) {
			int cnt = 0;
			int mid = (left + right) / 2;
			for (int i = 0; i < stones.length && cnt < k; i++) {
				if (stones[i] - mid < 0)
					cnt++;
				else
					cnt = 0;
			}

			if (cnt == k)
				right = mid - 1;
			else {
				left = mid + 1;
				answer = mid;
			}
		}
		return answer;

	}

	public static void main(String[] args) {
		int k = 3;
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		System.out.print(solution(stones, k));
	}

}
