import java.util.ArrayList;
import java.util.Arrays;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public boolean isSymmetric(TreeNode root) {
		ArrayList<Integer> leftChild = new ArrayList<Integer>();
		preorder(root, leftChild);
		ArrayList<Integer> rightChild = new ArrayList<Integer>();
		preorder2(root, rightChild);
		return Arrays.equals(leftChild.toArray(),rightChild.toArray());
	}

	void preorder(TreeNode root, ArrayList<Integer> Child) {
		if (root == null)
			Child.add(-101);
		else {
			Child.add(root.val);
			preorder(root.left, Child);
			preorder(root.right, Child);
		}
	}

	void preorder2(TreeNode root, ArrayList<Integer> Child) {
		if (root == null)
			Child.add(-101);
		else {
			Child.add(root.val);
			preorder2(root.right, Child);
			preorder2(root.left, Child);
		}
	}
}
