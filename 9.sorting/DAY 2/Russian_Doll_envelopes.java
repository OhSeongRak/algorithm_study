package Week9_Sorting;

import java.util.Arrays;
//import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;


public class Day2_Russian_Doll_envelopes {
	//LIS
	public static int maxEnvelopes(int[][] envelopes) {
        int[] count = new int[envelopes.length];

        Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0]);
        //오름차순으로 정렬
        //(2,3) (5,4) (6,4) (6,7)
        // 1     1      1     1
        // 1     2      2     3
        for(int i  = 0 ; i < envelopes.length ; i++) {
        	System.out.println(envelopes[i][0]+" "+envelopes[i][1]);
        	count[i] = 1; //모두 1로 초기화 = 자기 자신 하나가 포함 
        	for(int j = 0 ; j < i ; j++) {
        		//i와 j를 비교하면서 자기(i)보다 작은 애들(j)이 있으면 count 늘려감
        		if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
        			count[i] = Math.max(count[i], 1+count[j]);
        			//System.out.println("count[i] : " + count[i] + " ,  1+count[j]: "+(1+count[j]));
        			//w,h는 크기 때문에 1를 더해주고 앞과 비교하면서 큰 값으로 갱신시켜줌
         		}
        	}
        }

        Arrays.sort(count);
        return  count[envelopes.length-1] ;
        
    }
	public static void main(String[] args) {

		int[][] envelopes = { {5,4}, {6,4}, {6,7}, {2,3} };
//		int[][] envelopes = { {1,1}, {1,1}, {1,1} };
//		int[][] envelopes = { {4,5}, {6,7}, {2,3} };
		
		System.out.println(maxEnvelopes(envelopes));
		
	}

}
