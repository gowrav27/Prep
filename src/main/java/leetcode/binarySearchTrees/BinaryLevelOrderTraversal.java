package leetcode.binarySearchTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.binarySearchTrees.TreeNode;

public class BinaryLevelOrderTraversal
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootright = new TreeNode(20);
        
        root.left = rootLeft;
        root.right = rootright;
        
       System.out.println( levelOrder(root));

    }

    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        if(root== null){
            return  new ArrayList<List<Integer>>();
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        levelOrder(root, queue, lists);
        return lists;

    }
    
    public static void levelOrder(TreeNode root, Queue<TreeNode> queue, List<List<Integer>> lists)
    {
        if(queue.isEmpty()){
            return;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(TreeNode currNode : queue){
            list.add(currNode.val);
        }
        int size = list.size();
        lists.add(new ArrayList<Integer>(list));
        while(size > 0){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
            }
            
            if(node.right != null){
                queue.add(node.right);
            }
            size--;
        }
        levelOrder(root, queue, lists);
    }

}

