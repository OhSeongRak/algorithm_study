package Week12_Greedy;
import java.util.*;

public class Day2_Valid_Triangle_Number {
//	public static List<List<Integer>> set = new ArrayList<>();
//	public static List<Integer> list = new ArrayList<>();
//	public static int triangleNumber(int[] nums) {
//	
//	3개만 뽑는 조합을 set에 저장
//	-> 삼각형이 될 수 있는 조건을 검사하여 valid하다면 count 늘림 -> 유효성 x 
//	int n = nums.length;
//	boolean[] visited = new boolean[n];
//	combination(nums, visited, 0, n, 3);
//	System.out.println(set);
//	
//	int count = 0;
//	for(int i = 0 ; i < set.size() ; i++) {
//		if(set.get(i).get(2) < set.get(i).get(0) + set.get(i).get(1)) count++;
//	}
//
//    return count;
//        
//}
//
//public static void combination(int[] nums, boolean[] visited, int start, int n, int r) {
//	if(r == 0) {
//		list = new ArrayList<>();
//		for(int i = 0 ; i < n ; i++) {
//			if(visited[i]) 	list.add(nums[i]);
//		}
//		set.add(list);
//	}
//	for(int i = start ; i < n ; i++) {
//		visited[i] = true;
//		combination(nums, visited , i+1, n, r-1);
//		visited[i] = false;
//	}
//}
	public static int triangleNumber(int[] nums) {
		//오름차순으로 정렬하여 for문으로 돌면서 two pointer를 이용하여 수를 골라 조건 유효 판단
		//But, 조건이 유효할 때에만 count++ 하고 싶으나 
		// count += right-left 라고 함 ! -> 모르겠음 !
		
		Arrays.sort(nums);
		int n = nums.length;

		int count = 0;
		
		for(int i = 2 ; i < n ; i++) {
			int left = 0, right = i-1;
			
			while(left < right) {
				System.out.println(nums[i] + ","+nums[left]+","+nums[right]);
				//nums[i] 가장 긴 변 , num[left] num[right] 나머지 변
				if(nums[i] < nums[left]+nums[right]) {
					//count+= right - left; -> 더 효율적이겠지,,,근데 이유를 모르겠삼
//					count++;
					right--;
				}
				else left++;
				
			}
		}

		return count;
	}
	public static void main(String[] args) {
		int[] nums = { 2,2,3,4 };
//		int[] nums = { 4,2,3,4 };
		System.out.println(triangleNumber(nums));
	}

}
