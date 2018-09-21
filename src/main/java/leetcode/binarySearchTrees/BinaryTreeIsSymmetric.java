package leetcode.binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeIsSymmetric
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

 public boolean isSymmetric(TreeNode root) {
     List<TreeNode> list = new ArrayList<TreeNode>();
     if(root == null){
         return true;
     }
     if(root.left==null && root.right == null ){
         return true;
     }
     list.add(root.left);
     list.add(root.right);
        return isSymmetric2(list);
    }

    private boolean isSymmetric2(List<TreeNode> list)
    {
        if(list.isEmpty())
        {
            return true;
        }
        if(list.size()/2!=0){
            return false;
        }
        List<TreeNode> list2 = new ArrayList<TreeNode>();
        for(int i=0, j=list.size()-1; i<j;i++,j--){
            TreeNode leftNode = list.get(i);
            TreeNode rightNode = list.get(j);
            if(leftNode.val != rightNode.val){
                return false;
            }
            if(leftNode.left !=null && rightNode.right == null){
                return false;
            }
            if(leftNode.left ==null && rightNode.right != null){
                return false;
            }
            
            if(leftNode.right !=null && rightNode.left == null){
                return false;
            }
            if(leftNode.right ==null && rightNode.left != null){
                return false;
            }
            if(leftNode.left ==null && rightNode.right == null){
                continue;
            }
            if(leftNode.right ==null && rightNode.left == null){
                continue;
            }
            list2.add(leftNode.left);
            list2.add(leftNode.right);
            list2.add(rightNode.left);
            list2.add(rightNode.right);
        }

        return isSymmetric2(list2);
    }

}
