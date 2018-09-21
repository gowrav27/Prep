package leetcode.binaryTreeTraversalIterative;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    public List<Integer> postorderTraversal(TreeNode root)
    {
        LinkedList<Integer> ans = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null)
            return ans;

        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val); // remember this line, the add first makes all the difference
            if(cur.left != null)
            {
                stack.push(cur.left);
            }
            if(cur.right != null)
            {
                stack.push(cur.right);
            }
        }
        return ans;
    }
}
