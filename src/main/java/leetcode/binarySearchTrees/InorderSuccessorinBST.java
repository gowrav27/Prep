package leetcode.binarySearchTrees;

public class InorderSuccessorinBST
{

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
    {

            return inorderSuccessor(root, p, null);


    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null)
        {
            return null;
        }
        if(root.val < p.val)
        {
            return inorderSuccessor(root.right, p, null);
        }
        else
        {
            TreeNode leftNode = inorderSuccessor(root.left, p, null);
            if(leftNode != null)
            {
                return leftNode;
            }
            else
            {
                return root;
            }
        }
    }

    public TreeNode predecessor(TreeNode root, TreeNode p)
    {
        if(root == null)
            return null;

        if(root.val >= p.val)
        {
            return predecessor(root.left, p);
        }
        else
        {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }
}
