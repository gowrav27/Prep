package ctci.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueem
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int N = 4;
        List<List<Points>> lists = new ArrayList<List<Points>>();
        int[][] matrix = new int[N][N];
        NQueens(matrix, 0, 0, new ArrayList<Points>(), lists, N);
        System.out.println(lists);
    }

    private static boolean NQueens(int[][] matrix, int row, int column, List<Points> list, List<List<Points>> lists, int N)
    {
        if(list.size() == N)
        {
            lists.add(new ArrayList<Points>(list));
            return true;
        }
        if(row < 0 || row == matrix.length || column < 0 || column == matrix[0].length)
        {
            return false;
        }
        for(int i=0; i<matrix[0].length;i++){
            if(isValid(matrix, row, i)){
                matrix[row][i] = 1;
                list.add(new Points(row, i));
                if(NQueens(matrix, row + 1, column, list, lists, N))
                {
                    return true;
                }
                list.remove(list.size() - 1);
                matrix[row][i] = 0;
                }
        }
        return false;
    }

    private static boolean isValid(int[][] matrix, int row, int column)
    {
        for(int i = 0; i < matrix[0].length; i++)
        {
            if(matrix[row][i] == 1)
            {
                return false;
            }
        }
        for(int[] element : matrix)
        {
            if(element[column] == 1)
            {
                return false;
            }
        }
        int i = row;
        int j = column;
        // checking diagonal
        while(i >= 0 && j >= 0)
        {
            if(matrix[i][j] == 1)
            {
                return false;
            }
            i--;
            j--;
        }
        // checking anit-diagonal
        i = row;
        j = column;
        while(i > 0 && j < matrix[0].length)
        {
            if(matrix[i][j] == 1)
            {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}

class Points
{
    int x;
    int y;

    Points(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "x : " + x + " y:" + y + "\n";
    }
}
