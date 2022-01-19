package Week10_Binary_Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day2_Stepping_Stone {
	public static int solution(int distance, int[] rocks, int n) {
		int len = rocks.length ; 

		List<Integer> rock = new ArrayList<>();
		for(int i = 0 ; i < len ; i++) rock.add(rocks[i]);
		rock.add(distance);
		Collections.sort(rock);
		
		int left = 0; 
		int right = distance;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			int value = 0;
//			System.out.print(left + ", " + right + " = "+mid + " /");
			for(int i = 0 ; i <= len ; i++) {
				int dis = rock.get(i) - value; //각 바위 사이의 거리
				if(dis < mid) cnt++;  //mid보다 작다면 없애야하므로 제거해야할 바위 수 = cnt 증가시킴
				else value = rock.get(i); //그 외엔 다음 바위를 idx 로 갱신
			}
//			System.out.println(cnt);
			if(cnt <= n)  left = mid + 1; 
			//제거해야할 바위 수 = cnt가 n이하라면 덜 줄이기 위해서 mid를 높여줌
			else right = mid-1;
			//더 제거하기 위해 mid를 줄어줌
			
		}
		
	    return right;
	}
	public static void main(String[] args) {
		int distance = 25;
		int[] rocks = { 2,14,11,21,17 };
		int n = 2; 
		System.out.println(solution(distance, rocks, n));

	}

}
