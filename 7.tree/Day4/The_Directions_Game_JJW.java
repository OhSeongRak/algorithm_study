import java.util.*;

class Solution {	
    public static class TreeNode {
		int index, x,y;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() { }
	    TreeNode(int index, int x, int y) {
	    	this.index = index;
	    	this.x = x;
	    	this.y = y;
	    }
		@Override
		public String toString() {
			return index + " : ( "+ x + " , " + y +" )";
		}
		
		
		
	}
	static ArrayList<TreeNode> node = new ArrayList<TreeNode>();
	static ArrayList<Integer> pre = new ArrayList<>();
	static ArrayList<Integer> post = new ArrayList<>();
	public static void insert(TreeNode parent, TreeNode children) {
		//부모의 조건 
		//무조건 자식의 y보다 크다
		//1. 자식의 x보다 작을 경우 : 오른쪽 자식
		//2. 자식의 x보다 클 경우 : 왼쪽 자식
		
		if(parent.x < children.x) { //parent의 오른쪽 자식
			if(parent.right == null) {//비어있다면 연결
				parent.right = children;
			}
			else {//비어있지 않다면 오른쪽 자식의 자식으로 연결
				insert(parent.right, children);
			}
		}
		else { //parent의 왼쪽 자식
			if(parent.left == null) {//비어있다면 연결
				parent.left = children;
			}
			else {//비어있지 않다면 왼쪽 자식의 자식으로 연결
				insert(parent.left, children);
			}
		}
	}
	public static void preorder(TreeNode root) {
		//전위순회 : root -> left -> right
		if(root == null) return;
		pre.add(root.index);
		preorder(root.left);
		preorder(root.right);	
	}
	public static void postorder(TreeNode root) {
		//후위순회 : left -> right -> root
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		post.add(root.index);
		
	}
	public static int[][] solution(int[][] nodeinfo) {
	    int[][] answer = new int[2][nodeinfo.length];
	    
	    for(int i = 0 ; i < nodeinfo.length ; i++) {
	    	node.add(new TreeNode(i+1, nodeinfo[i][0], nodeinfo[i][1]));
	    	
	    	//index , x값, y값
	    }
	    
	   //y값에 따른 내림차순 정렬
	   Collections.sort(node, (o1, o2) -> o2.y - o1.y);
	
	    // for(int i = 0 ; i < node.size() ; i++) {
	    // 	System.out.println(node.get(i));
	    // }
	    
	    TreeNode root = node.get(0); 
	    
	    for(int i = 1 ; i < node.size(); i++) {
	    	insert(root, node.get(i));
	    }
	    
	   preorder(root);
	   postorder(root);
	   
//	   for(int val: pre) System.out.print(val+" "); 
//	   System.out.println();
//	   for(int val: post) System.out.print(val+" ");
	    
	   for(int i = 0 ; i < nodeinfo.length ; i++) {
		   answer[0][i] = pre.get(i);
		   answer[1][i] = post.get(i);
	   }
	   
	   
	    return answer;
	}
}
