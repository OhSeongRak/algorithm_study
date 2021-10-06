package Tree;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Most_Frequent_Subtree_Sum_OSR {

	static Hashtable<Integer, Integer> ht;

	public static int dfs(TreeNode node) {
		int sum = 0;

		if (node != null) {
			sum += dfs(node.left);
			sum += dfs(node.right);
			sum += node.val;

			System.out.print(sum + " ");
			ht.put(sum, ht.getOrDefault(sum, 0) + 1);
		}

		return sum;
	}

	public static int[] findFrequentTreeSum(TreeNode root) {

		// ht : <Sum of subtree, count>
		ht = new Hashtable<Integer, Integer>();
		dfs(root);

		Set<Integer> set = ht.keySet();
		int max = 0;

		// count의 max값 찾기
		for (Integer k : set) {
			System.out.print("(" + k + ", " + ht.get(k) + ")");
			if (max < ht.get(k))
				max = ht.get(k);
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (Integer k : set) {
			if (max == ht.get(k))
				list.add(k);
		}

		int[] arr = new int[list.size()];

		for (int i = 0; i < arr.length; i++)
			arr[i] = list.get(i);

		return arr;
	}

	public static void main(String[] args) {

	}

}
