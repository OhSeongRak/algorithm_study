package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle_OSR {
//	public static List<Integer> findRoute(List<List<Integer>> triangle, int pos, int N) {
//		List<Integer> list = new ArrayList<Integer>();
//		
//		list.add(0, pos);
//		for(int i = N; i > 0; i--) {
//			if(triangle.get(i).get(pos - 1) < triangle.get(i).get(pos))
//				list.add(0, --pos);
//			else
//				list.add(0, pos);
//		}
//		list.add(0, 0);
//		
//		return list;
//	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {

		// best 코드
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
        
		// 실패 코드
//		List<List<Integer>> posList = new ArrayList<List<Integer>>();
//		posList.add(new ArrayList(Arrays.asList(0)));
//		int sum = 0;
//
//		for (int i = 1; i < triangle.size(); i++) {
//			
//			for (int n = 0; n < posList.size(); n++) {
//				int pos = posList.get(n).get(i - 1);
//				
//				if (triangle.get(i).get(pos) < triangle.get(i).get(pos + 1))
//					posList.get(n).add(pos);
//				else
//					posList.get(n).add(pos + 1);	
//			}
//			
//			boolean hasMin = false;
//			int minIdx = triangle.indexOf(Collections.min(triangle.get(i)));
//			
//			for(int n = 0; n < posList.size(); n++) {
//				if(posList.get(n).get(i) == minIdx) {
//					hasMin = true;
//					break;
//				}
//			}
//			
//			if(hasMin = false)
//				posList.add(findRoute(triangle, minIdx, i));
//		}
//
//		return sum;

	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);

		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);

		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);

		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);

		System.out.print(minimumTotal(list));

	}

}
