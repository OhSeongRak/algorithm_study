package Week7_Tree;

import java.util.*;


public class Day3_Binary_Tree_Right_Side_View_JJW {
	public static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() { }
	    
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	    	this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
     public static List<Integer> rightSideView(TreeNode root) {
         
    	 //if(root == null) return rightside;
         // rightside.add(root.val);
         // rightSideView(root.right);
         // return rightside;
         //이렇게 오른쪽으로만 내려가서 찾으려고 하니 안됨 ^^
    	 
    	 
    	 
         //BFS 너비 탐색하면서 right부분만 골라내기
         List<Integer> rightside = new LinkedList<Integer>();
         Queue<TreeNode> queue = new LinkedList<>();
         TreeNode temp = root;
         
         if(root == null) return rightside;
         queue.add(root);
         
         while(!queue.isEmpty()){
            int size = queue.size(); //->꼭 변수 이용
             for(int i = 0 ; i < size; i++){
                 temp = queue.poll();
                 //System.out.println("temp : "+temp.val);
                 //왼쪽 자식, 오른쪽 자식 (전위순회?)
                 if(temp.left != null){
                     queue.add(temp.left);
                     //System.out.println(temp.left.val);
                 }
                 if(temp.right != null){
                     
                     queue.add(temp.right);
                    // System.out.println(temp.right.val);
                 }   
             }
             rightside.add(temp.val);
             //queue가 쌓인다면 마지막 temp는 항상 오른쪽 자식이 될것임!
             //따라서 rightside 에 temp를 추가
             
         }
         return rightside;
     }
	 public static void preorder(TreeNode root) {
		 if(root!=null) {
			 System.out.println(root.val);
			 preorder(root.left);
			 preorder(root.right);
		 }
	 }
	public static void main(String[] args) {
		TreeNode LeafLeftNode1 = new TreeNode();
		TreeNode LeafRightNode1 = new TreeNode(5);
		TreeNode midLeftNode1 = new TreeNode(2,LeafLeftNode1, LeafRightNode1);
		
		TreeNode LeafLeftNode2 = new TreeNode();
		TreeNode LeafRightNode2 = new TreeNode(4);
		TreeNode midRightNode2 = new TreeNode(3,LeafLeftNode2, LeafRightNode2);
		
		TreeNode root = new TreeNode(1, midLeftNode1, midRightNode2);
		
//		preorder(root);
//		int len = pre.size();
//   	 	
//		for(int i = len/2 +1 ; i < len ; i++) {
//			System.out.println(pre.get(i));
//   	 	}
		List<Integer> ans = new LinkedList<Integer>();
		ans = rightSideView(root);
		System.out.println(ans);
	}

}
