package leetcode.tree;

public class ValidateBinarySearchTree
{
    public boolean isValidBST(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        if(root.left == null && root.right == null)
        {
            return true;
        }
        if(root.left != null && root.right != null)
        {
            if(root.left.val >= root.val || root.right.val <= root.val)
            {
                return false;
            }
            return isValidBST(root.left) && isValidBST(root.right);
        }
        if(root.left != null)
        {
            if(root.left.val >= root.val)
            {
                return false;
            }
            return isValidBST(root.left);
        }
        if(root.right != null)
        {
            if(root.right.val <= root.val)
            {
                return false;
            }
            return isValidBST(root.right);
        }
        return true;

    }
}
