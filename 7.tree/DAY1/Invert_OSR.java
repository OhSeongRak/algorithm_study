package Tree;

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

public class Invert_OSR {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
    	if(root.left == null && root.right == null)
    		return root;
    	
        TreeNode tmp = invertTree(root.left); 
        root.left = invertTree(root.right); 
        root.right = tmp;
        
    	return root;
    }
    
	public static void main(String[] args) {
		

	}

}
