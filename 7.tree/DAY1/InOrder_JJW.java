package Week7_Tree;

import java.util.*;


import java.io.*;

public class Day1_InOrder_JJW {
	public static int N;
	public static char[] tree;
	public static TreeNode root;
	public static StringBuilder sb = new StringBuilder();
	
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
	public static void inorder(int idx) {
		if(idx > N) return;
		
		inorder(idx*2); //왼쪽자식
		sb.append(tree[idx]);
		inorder(idx*2+1); //오른쪽 자식
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		tree = new char[N+1];
		
		
		for(int test_case = 1; test_case <= 10 ; test_case++) {
			for(int i = 0 ; i < N ; i++) {
//				st = new StringTokenizer(br.readLine());
//				tree[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
				String[] s = br.readLine().split(" ");
				if(s.length == 2) {
					
				}
				
			
			}
				//sb.append("#").append().append(" ");
				
				inorder(1);
				
				sb.append('\n');
			
			System.out.println(sb);

		}
		
	}

}
