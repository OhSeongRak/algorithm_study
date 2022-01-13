package Week10_Binary_Search;

import java.util.Arrays;

public class Day1_MinMaxDivision {
	public static int solution(int K, int M, int[] A) {
		

		int start = Integer.MIN_VALUE; 
		int end = 0; 

		
		for(int val : A) {
			end += val;
			start = Math.max(start, val);

		}

		if(K >= A.length) return start;
		else if (K == 1) return end;


		 while(start <= end){
	            int mid = (start + end)/2;
	            if(possible(mid, K, A)) end = mid-1;
	            else start = mid+1;
	        }
		
		return start;
	}
	public static boolean possible(int sum, int K, int[] A){
        int sec_per_sum = 0;
        int sec_cnt = 1;

        for(int val : A){
            if(sec_per_sum + val > sum){
                sec_per_sum = val;
                sec_cnt ++;
            }
            else sec_per_sum += val;

            if(sec_cnt > K) return false;
        }
        return true;
    }
	public static void main(String[] args) {

		int K = 3;
		int M = 5;
		int[] A = {2,1,5,1,2,2,2};
		System.out.println(solution(K,M,A));

	}

}
