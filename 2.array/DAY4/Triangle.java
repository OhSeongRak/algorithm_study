package Array;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {

		// best �ڵ�
		int n = triangle.size();
		int[] dp = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
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
