package leetcode.dynamicprogramming;

public class RobotPath
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int m = 70;

        // System.out.println(uniquePaths(m, m));
        System.out.println(uniquePathsDp(m, m));
    }

    public static int uniquePaths(int m, int n)
    {
        return uniquePaths(0, 0, m, n);
    }

    public static int uniquePaths(int x, int y, int m, int n)
    {
        if(x == m - 1 && y == n - 1)
        {
            return 1;
        }
        if(x > m || y > n)
        {
            return 0;
        }
        int count = 0;
        count += uniquePaths(x + 1, y, m, n);
        count += uniquePaths(x, y + 1, m, n);
        return count;
    }

    public static int uniquePathsDp(int m, int n)
    {
        if(m == 0 || n == 0)
        {
            return 0;
        }
        if(m == 1 || n == 1)
        {
            return 1;
        }
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++)
        {
            dp[0][i] = 1;
        }
        for(int i = 0; i < m; i++)
        {
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
