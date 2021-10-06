import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public int[] findFrequentTreeSum(TreeNode root) {
		Hashtable<Integer, Integer> HtOfSumAndFrequent = new Hashtable<Integer, Integer>();

		travel(root, HtOfSumAndFrequent);

		int max = 0;
		int num = 0;
		for (int key : HtOfSumAndFrequent.keySet()) {
			if (max < HtOfSumAndFrequent.get(key))
				max = HtOfSumAndFrequent.get(key);
		}

		ArrayList<Integer> answerArrayList = new ArrayList<Integer>();

		for (int key : HtOfSumAndFrequent.keySet()) {
			if (max == HtOfSumAndFrequent.get(key))
				answerArrayList.add(key);
		}

		int[] answerArray = new int[answerArrayList.size()];
		for (int i = 0; i < answerArrayList.size(); i++) {
			answerArray[i] = answerArrayList.get(i);
		}
		return answerArray;

	}

	void travel(TreeNode root, Hashtable<Integer, Integer> HtOfSumAndFrequent) {
		if (root == null)
			return;
		int key = func_SumValueofTree(root);

		HtOfSumAndFrequent.put(key, HtOfSumAndFrequent.getOrDefault(key, 0) + 1);
		travel(root.left, HtOfSumAndFrequent);
		travel(root.right, HtOfSumAndFrequent);
	}

	int func_SumValueofTree(TreeNode root) {
		if (root == null)
			return 0;

		return root.val + func_SumValueofTree(root.left) + func_SumValueofTree(root.right);

	}
}
