package Week7_Tree;

import java.util.*;
import java.io.*;
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
    	this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day2_Symmetric_Tree_JJW {
	//대칭 -> 왼쪽 == 오른쪽 
	 public static boolean isSymmetric(TreeNode root) {
    	 
		 TreeNode left = root.left;
		 TreeNode right = root.right;
		 return subSymmetric(left, right);
	        
	        
	 }
	 public static boolean subSymmetric(TreeNode left, TreeNode right) {
         
         //자식의 유무
		 if(left == null && right == null) return true;
		 //둘다 자식이 없다면 true 반환 -> 이때까지가 true로 다 들어왔기 때문에 마무리까지 true
         
		 else if((left == null && right != null) || (right == null && left != null)) {
			 return false;
		 } //둘 중 하나만 자식이 있따면 false 반환
		 
         else{
             
            //값의 일치
             if(left.val != right.val) {
                 return false;
             } //값이 다르다면 true

             else{    
                return subSymmetric(left.left, right.right) && subSymmetric(left.right, right.left);
             }//값이 같을 경우는 재귀를 해준다

         }
         
	 }
	 
	public static void main(String[] args) {
		TreeNode LeafLeftNode1 = new TreeNode(3);
		TreeNode LeafRightNode1 = new TreeNode(4);
		TreeNode midLeftNode1 = new TreeNode(2,LeafLeftNode1, LeafRightNode1);
		
		TreeNode LeafLeftNode2 = new TreeNode(4);
		TreeNode LeafRightNode2 = new TreeNode(3);
		TreeNode midRightNode2 = new TreeNode(2,LeafLeftNode2, LeafRightNode2);
		
		TreeNode root = new TreeNode(1, midLeftNode1, midRightNode2);
		
		boolean res = isSymmetric(root);
		System.out.println(res);
	}

}
