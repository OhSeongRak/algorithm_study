package Tree;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Symmetric_Tree_OSR {

	static ArrayList<Integer> leftList;
	static ArrayList<Integer> rightList;

	public static void preorderFirstLeft(TreeNode root) {
		if (root != null) {
			leftList.add(root.val);
			preorderFirstLeft(root.left);
			preorderFirstLeft(root.right);
		}
		else
			leftList.add(0);
	}

	public static void preorderFirstRight(TreeNode root) {
		if (root != null) {
			rightList.add(root.val);
			preorderFirstRight(root.right);
			preorderFirstRight(root.left);
		}
		else
			rightList.add(0);
	}
	
	public static boolean isSymmetric(TreeNode root) {

		leftList = new ArrayList<Integer>();
		rightList = new ArrayList<Integer>();
		
		preorderFirstLeft(root.left);
		preorderFirstRight(root.right);
		
		if(leftList.size() != rightList.size())
			return false;
		
		for(int i = 0; i < leftList.size(); i++) {
			if(leftList.get(i) != rightList.get(i))
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {

		System.out.println(isSymmetric(new TreeNode(1, null, null)));
	}

}
