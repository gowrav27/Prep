package com.blogspot.aknowakowski.jodaTime.divideConqueror;

public class MNWays
{
    static int endRow = 4;
    static int endColumn = 7;
    static int i = 1;
    static int j = 1;
    public static void main(String[] args)
    {
        System.out.println(mnways(1, 1, 0));
        System.out.println(getWays(4, 7));

    }

    private static int mnways(int row, int column, int count)
    {
        if(row == endRow && column == endColumn)
        {
            return 1;
        }
        if(row > endRow || column > endColumn || row < 1 || column < 1)
        {
            return 0;
        }
        System.out.println("i == " + i++);
        count = mnways(row + 1, column, count) + mnways(row, column + 1, count);
        return count;
    }

    private static int getWays(int m, int n)
    {
        if(m - 1 == 0 && n - 1 == 0)
        {
            return 1;
        }
        if(m == 0 || n == 0)
        {
            return 0;
        }
        System.out.println("j == " + j++);
        return getWays(m - 1, n) + getWays(m, n - 1);

    }

}
