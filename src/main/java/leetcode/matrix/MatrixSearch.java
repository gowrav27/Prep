package leetcode.matrix;

public class MatrixSearch
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    public boolean searchMatrix(int[][] matrix, int target)
    {
        if(matrix.length == 0)
        {
            return false;
        }
        return search(matrix, target, 0, matrix[0].length - 1);
    }

    public boolean search(int[][] matrix, int target, int row, int col)
    {
        if(row >= matrix.length)
        {
            return false;
        }
        if(col < 0)
        {
            return false;
        }
        int val = matrix[row][col];
        if(val == target){
            return true;
        }
        if(val< target){
            return search(matrix, target, row+1, col);
        }else{
            return search(matrix, target, row, col-1);
        }

    }
}
