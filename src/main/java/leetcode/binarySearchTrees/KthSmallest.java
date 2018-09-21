package leetcode.binarySearchTrees;

public class KthSmallest
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    int result = 0;

    public int kthSmallest(TreeNode root, int k)
    {
        kthSmallest(root, k);
        return result;
    }

    public void kthSmallestt(TreeNode root, int k)
    {
        if(root == null)
        {
            return;
        }
        kthSmallestt(root.left, k);
        k++;
        if(k == 0)
        {
            result = root.val;
             return;
        }
        kthSmallestt(root.right, k);
    }

}
