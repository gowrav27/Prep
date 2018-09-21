package leetcode.binarySearchTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryZigZagTraversal
{

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootright = new TreeNode(20);
        
        TreeNode rootright_ChildLeft = new TreeNode(15);
        TreeNode rootright_ChildRight = new TreeNode(7);
        
        rootright.left = rootright_ChildLeft;
        rootright.right = rootright_ChildRight;
                
        root.left = rootLeft;
        root.right = rootright;
        
        
       System.out.println( zigzagLevelOrder(root));

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        if(root == null)
        {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        zigzagLevelOrder(root, stack1, stack2, lists);
        return lists;

    }

    public static void zigzagLevelOrder(TreeNode root, Stack<TreeNode> stack1, Stack<TreeNode> stack2, List<List<Integer>> lists)
    {
        if(stack1.isEmpty() && stack2.isEmpty())
        {
            return;
        }
        List<Integer> list = new ArrayList<Integer>();
        if(!stack1.isEmpty())
        {
            popParentInsertChild(stack1, stack2, list);
            lists.add(new ArrayList<Integer>(list));
            zigzagLevelOrder(root, stack1, stack2, lists);
        }
        if(!stack2.isEmpty())
        { 
            popParentInsertChild2(stack2, stack1, list);
            lists.add(new ArrayList<Integer>(list));
            zigzagLevelOrder(root, stack1, stack2, lists);
        }
        return;
    }
    
    private static void popParentInsertChild(Stack<TreeNode> parentStack, Stack<TreeNode> childStack, List<Integer> list){
       
        int size = parentStack.size();
        while(size > 0)
        {
            TreeNode node = parentStack.pop();
            list.add(node.val);
            if(node.left != null)
            {
                childStack.add(node.left);
            }

            if(node.right != null)
            {
                childStack.add(node.right);
            }
            size--;
        }
    }
    
    private static void popParentInsertChild2(Stack<TreeNode> parentStack, Stack<TreeNode> childStack, List<Integer> list){
        
        int size = parentStack.size();
        while(size > 0)
        {
            TreeNode node = parentStack.pop();
            list.add(node.val);
            if(node.right != null)
            {
                childStack.add(node.right);
            }

            if(node.left != null)
            {
                childStack.add(node.left);
            }
            size--;
        }
    }
}
