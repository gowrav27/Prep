package ctci.recursion;

import java.util.List;

public class Robot
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    private static boolean countTopDown(int[][] matrix, int row, int column, List<Point> points)
    {
        if(matrix.length == row && matrix[0].length == column)
        {
            return true;
        }
        if(row > matrix.length || column > matrix[0].length || matrix[row][column] == -1)
        {
            return false;
        }

        points.add(new Point(row, column));
        if(countTopDown(matrix, row + 1, column, points))
        {
            return true;
        }

        if(countTopDown(matrix, row, column + 1, points))
        {
            return true;
        }
        int last = points.size() - 1;
        points.remove(last);
        return false;
    }


    private static boolean countBottomUp(int[][] matrix, int row, int column, List<Point> points)
    {
        if(row == 0 && column == 0)
        {
            return true;
        }
        if(row < 0 || column < 0 || matrix[row][column] == -1)
        {
            return false;
        }

        points.add(new Point(row, column));
        if(countBottomUp(matrix, row - 1, column, points))
        {
            return true;
        }

        if(countBottomUp(matrix, row, column - 1, points))
        {
            return true;
        }
        int last = points.size() - 1;
        points.remove(last);
        return false;
    }
}

class Point
{
    int x;
    int y;

    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}