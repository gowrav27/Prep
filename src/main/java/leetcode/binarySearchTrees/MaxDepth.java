package leetcode.binarySearchTrees;

public class MaxDepth
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    public int maxDepth(TreeNode root)
    {
        return maxDepth2(root);

    }
    
    public int maxDepth2(TreeNode root)
    {
        if(root == null){
            return 0;
        }
        return 1+ Math.max(maxDepth2(root.left), maxDepth2(root.right));
    }
}
