import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
    	Hashtable<Integer,Integer> answer = new Hashtable<Integer,Integer>();
    	
    	int tmpHeight=0;
        
    	func1(root,answer,tmpHeight);
        
    	ArrayList<Integer> answerValue = new ArrayList<Integer>();
    	
    	for( int i = 1 ; i <= answer.size(); i++) {
    		answerValue.add(answer.get(i));
    	}
    	
    	
        return answerValue;
    }
    void func1(TreeNode root,Hashtable<Integer,Integer> answer,int tmpHeight) {
    	tmpHeight++;
    	if( root == null)
    		return;
    	
    	if(answer.containsKey(tmpHeight))
    		answer.replace(tmpHeight,root.val);
    	else
    		answer.put(tmpHeight, root.val);
    	
    	func1(root.left,answer,tmpHeight);
    	func1(root.right,answer,tmpHeight);
    	
    }
}
