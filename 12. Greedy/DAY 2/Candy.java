package Week12_Greedy;

import java.util.Arrays;

public class Day2_Candy {
//	WRONG PROCESS
//	세 수를 비교했을 때 모든 경우의 수를 계산
//	양 끝 값 -> 끝때만 증가
//	그 사이값 -> 크면 증가, 같으면 그 전값과 동일, 작으면 감소
//	for(int i = 0 ; i < n ; i++) {
//		System.out.print(ratings[i]+" : ");
//		if(ratings[i] == 0) continue;
//		
//		if(i == 0) {
//			if(ratings[i] > ratings[i+1]) candy[i]++;
//		}
//		else if(i == n-1) {
//			if(ratings[i] > ratings[i-1]) candy[i]++;
//		}
//		else {
//
//			if(ratings[i] > ratings[i-1] || ratings[i] > ratings[i+1]) candy[i]++;
//			if(ratings[i]  ratings[i-1] || ratings[i] >= ratings[i+1]) candy[i] = candy[i-1]-1;
//			if(ratings[i] <= ratings[i-1] ||  ratings[i] <= ratings[i+1]) candy[i]--;
//		}
//	}
	public static int candy(int[] ratings) {
		//캔디를 늘릴 수 있는 조건 
		//크기만 비교하면 됨 
		//But, 끼인 수 , i , i-1 (세 값)를 비교해도 다음 수들을 알 수가 없기 때문에 한번에 확정지을 수 없다
		// -> 클 때만 증가 
		//<- 클 때 그대로인 값도 있고, +1 되는 상황이 있음  =>  그대로인지, 이 전의 수의 +1 중 max 값을 비교
				
		int n = ratings.length;
		int minimum = 0;
		int[] candy = new int[n];
		Arrays.fill(candy, 1);
		
		

		for(int i =1 ; i < n; i++) {
			if(ratings[i] > ratings[i-1]) candy[i] = candy[i-1]+1;
		}
		for(int c :  candy) System.out.print(c+" ");
//		System.out.println();
		
		for(int i = n-1 ; i > 0 ; i--) {
			if(ratings[i-1] > ratings[i]) {
				candy[i-1] = Math.max(candy[i-1] , candy[i] + 1);
			}
		}
//		System.out.println();
		for(int c : candy) {
			minimum += c;
			System.out.print(c+" ");
		}

		return minimum;
	}
	public static void main(String[] args) {
//		int[] ratings = { 1,0,2 };
//		int[] ratings = {1,2,2};
//		int[] ratings = {1,3,2,2,1};
//		int[] ratings = { 1,2,87,87,87,2,1};
		int[] ratings = { 29,51,87,87,72,12};
		System.out.println(candy(ratings));
	}

}
