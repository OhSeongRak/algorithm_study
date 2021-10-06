//BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode temp=root;
        if(root==null)
            return res;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                temp=q.remove();
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            res.add(temp.val);
        }
        return res;
    }
}


//DFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        rightViewHelper(root,0,res);
        return res;
    }
    public void rightViewHelper(TreeNode root,int level,List<Integer> res)
    {
        if(root==null)
            return;
        if(level==res.size())
            res.add(root.val);
        rightViewHelper(root.right,level+1,res);
        rightViewHelper(root.left,level+1,res);
    }
}
