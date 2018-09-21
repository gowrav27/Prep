package leetcode.binarySearchTrees;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    static Map<TreeNode, Integer> nodetoHeight = new HashMap<TreeNode, Integer>();
    public boolean isBalanced(TreeNode root)
    {   
        if(root == null){
            return true;
        }
        return isBalanced2(root);
    }

    private boolean isBalanced2(TreeNode root)
    {
        if(root == null){
            return true;
        }
        int leftTree = heightOfTree(root.left);
        int rightTree = heightOfTree(root.right);
        if( Math.abs(leftTree - rightTree) > 1){
            return false;
        }
        return isBalanced2(root.left) && isBalanced2(root.right) ;
    }

    private static int heightOfTree(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        if(nodetoHeight.containsKey(root)){
           return nodetoHeight.get(root);
        }else{
            int val = 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
            nodetoHeight.put(root, val);
            return val;
        }
    }
}
