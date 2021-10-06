package Tree;

import java.util.ArrayList;
import java.util.List;

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

public class Binary_Tree_Right_Side_View_OSR {

	static List<Integer> tree;

	public static void dfs(TreeNode node, int height) {
		if (node != null) {
			if (tree.size() < height)
				tree.add(node.val);

			dfs(node.right, height + 1);
			dfs(node.left, height + 1);
		}
	}

	public static List<Integer> rightSideView(TreeNode root) {
		tree = new ArrayList<Integer>();

		dfs(root, 1);

		return tree;
	}

	public static void main(String[] args) {

	}

}
