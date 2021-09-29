package Week7_Tree;

import java.util.*;

public class Day1_Invert_JJW {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val){ this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			 this.val = val;
			 this.left = left;
			 this.right = right;
		}
	}
	
	
	public static TreeNode invertTree(TreeNode root) {
		
		 if(root == null) return null;
			
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
			
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
				
			//swap
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
				
	        //자식들이 있다면 queue에 추가시켜 밑동가리들도 swap할 수 있도록 함
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
				
		}		
			
		return root;
	}

	public static void main(String[] args) {
	
		TreeNode root, left, right;
		
//		int[] data = {4,2,7,1,3,6,9};
//		
//		for(int i = data.length / 2 - 1 ; i >= 0; i--) {
//			
//			left = new TreeNode(i*2+1);
//			right = new TreeNode(i*2+2);
//			root = new TreeNode(i, left, right);
//		
//		}
		left = new TreeNode(1);
		right = new TreeNode(3);
		root = new TreeNode(2, left, right);
		
		invertTree(root);
			
		
	}

}
