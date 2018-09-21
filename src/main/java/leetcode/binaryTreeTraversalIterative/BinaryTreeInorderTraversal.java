package leetcode.binaryTreeTraversalIterative;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    public List<Integer> inorderTraversal(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> nums = new ArrayList<Integer>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty())
        {
            while(curr != null)
            {

                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            nums.add(curr.val);
            curr = curr.right;

        }
        return nums;
    }
}
