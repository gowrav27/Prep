package leetcode.binarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintBinaryTree
{

    public static void main(String[] args)
    {
        
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootright = new TreeNode(20);
        
        root.left = rootLeft;
        root.right = rootright;
        
       System.out.println( printTree(root));
    }

    public static List<List<String>> printTree(TreeNode root)
    {
        int r= heightOfTree(root);
        int c = (int) (Math.pow(2, r) -1);
        List<String> list = new ArrayList<String>(c);
        List<List<String>> lists = new  ArrayList<List<String>>(r);
        for(int i=0 ;i< r;i++){
            List<String> newList = new ArrayList<String>(c);
            for(int j=0 ;j< c;j++){
                newList.add("");
            }
            lists.add(newList);
        }
        int[][] matrix = new int[r][c];
        printTree(root, lists, 0, 0, c-1);
        return lists;

    }
    
    private static void printTree(TreeNode root, List<List<String>> lists, int r, int cStart, int cEnd)
    {
        if(root == null || r>=lists.size()){
            return;
        }
        int cell = (cStart + cEnd) /2;
        List<String> list  = lists.get(r);
        list.set(cell, String.valueOf(root.val));
        printTree(root.left, lists, r+1, cStart, cell-1);
        printTree(root.right, lists, r+1, cell+1, cEnd);
        
    }

  

    private static int heightOfTree(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+ Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }
    
    private static void printTree(TreeNode root, int[][] matrix, int r, int cStart, int cEnd)
    {
        if(root == null || r>=matrix.length){
            return;
        }
        int cell = (cStart + cEnd) /2;
        matrix[r][cell] = root.val;
        printTree(root.left, matrix, r+1, cStart, cell-1);
        printTree(root.right, matrix, r+1, cell+1, cEnd);
        
    }
}
