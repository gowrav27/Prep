package leetcode.binarySearchTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree
{

    public static void main(String[] args)
    {

        List<Double> list = new ArrayList<Double>();
        double f =29;
        double s =2;
        list.add((double) (f / s));
        System.out.println(list);

    }

    public List<Double> averageOfLevels(TreeNode root)
    {
        if(root == null){
            return new ArrayList<Double>();
        }
        List<Double> list = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            double count = size;
            double sum = 0;
            while(size > 0)
            {
                TreeNode node = queue.poll();
                if(node.left != null)
                {
                    queue.add(node.left);
                }
                if(node.right != null)
                {
                    queue.add(node.right);
                }
                sum = sum + node.val;
                size--;
            }
            list.add((double) (sum / count));
        }
        return list;

    }
}
