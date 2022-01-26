package Week12_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1_Gas_Station {
	public static int canCompleteCircuit(int[] gas, int[] cost) {

		int n = cost.length;
		int ans = 0, sum = 0;
 
        // -1 이 되는 조건 = gas보다 cost가 더 많으면 무조건 갈 수 없다
        int gas_sum = 0, cost_sum = 0;
        for(int i = 0 ; i < n ; i++) {
        	gas_sum += gas[i];
        	cost_sum += cost[i];
        }
        if(gas_sum < cost_sum) return -1;
        
        
        //cost가 gas보다 크기 때문에 cost-gas가 양수이면 가능
        for(int i = 0 ; i < n ; i++) {
        	sum += gas[i] - cost[i];
        	System.out.println(sum);
        	if(sum < 0) {
        		//누적합이 음수이면 그 이전의 값 또한 처음 인덱스가 될 수 없으므로 
        		//sum은 다시 0으로 갱신하고 ans는 다음 인덱스로 미룬다
        		sum = 0; 
        		ans = i+1;
        	}	
        }

		return ans ;
		
    }
	public static void main(String[] args) {
//		int[] gas = {1,2,3,4,5};
//		int[] cost = {3,4,5,1,2};
//		int[] gas = {2,3,4};
//		int[] cost = {3,4,3};
//		int[] gas = {5,1,2,3,4};
//		int[] cost = {4,4,1,5,1};
		int[] gas = {3,1,1};
		int[] cost = {1,2,2};
		System.out.println(canCompleteCircuit(gas, cost));
	}

}
