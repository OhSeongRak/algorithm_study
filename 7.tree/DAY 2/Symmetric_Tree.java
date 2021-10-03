public boolean isSymmetric(TreeNode root) {
    return root==null || isSymmetricHelp(root.left, root.right);
    // if root is null then immediately return true
    // is root is not null then
    //							if isSymmetricHelp is true then return true
    //							if isSymmetricHelp is false then return false
}

private boolean isSymmetricHelp(TreeNode left, TreeNode right){
	// if ( T or T) return true;
	// if ( T or F ) return false;
    if(left==null || right==null)
        return left==right;
    if(left.val!=right.val)
        return false;
    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
}
