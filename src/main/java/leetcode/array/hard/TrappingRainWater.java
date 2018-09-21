package leetcode.array.hard;

public class TrappingRainWater
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[][] matrix = {{0}, {1}};
        setZeroes(matrix);

    }

    public int trap(int[] height)
    {
        int[] maxInLeft = new int[height.length];
        int[] maxInRight = new int[height.length];
        int maxSoFar = 0;
        for(int i = height.length - 1; i >= 0; i--)
        {
            if(maxSoFar < height[i])
            {
                maxInRight[i] = height[i];
                maxSoFar = height[i];
            }
            else
            {
                maxInRight[i] = maxSoFar;
            }
        }
        maxInRight[height.length - 1] = 0;
        maxSoFar = 0;
        for(int i = 0; i < height.length; i++)
        {
            if(maxSoFar < height[i])
            {
                maxInLeft[i] = height[i];
                maxSoFar = height[i];
            }
            else
            {
                maxInLeft[i] = maxSoFar;
            }
        }
        maxInLeft[0] = 0;
        maxSoFar = 0;

        int maxArea = 0;
        for(int i = 0; i < height.length; i++)
        {
            maxArea += Math.max(Math.min(maxInLeft[i], maxInRight[i]) - height[i], 0);
        }
        return maxArea;
    }

    public static void setZeroes(int[][] matrix)
    {
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0 && i == 0 && j == 0)
                {
                    isFirstRowZero = true;
                    isFirstColumnZero = true;
                    continue;
                }
                if(matrix[i][j] == 0 && i == 0)
                {
                    isFirstRowZero = true;
                    continue;
                }
                if(matrix[i][j] == 0 && j == 0)
                {
                    isFirstColumnZero = true;
                    continue;
                }
                if(matrix[i][j] == 0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++)
        {
            if(matrix[i][0] == 0)
            {
                for(int j = 0; j < matrix[0].length; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < matrix[0].length; j++)
        {
            if(matrix[0][j] == 0)
            {
                for(int i = 0; i < matrix.length; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if(isFirstRowZero)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                matrix[i][0] = 0;
            }
        }
        if(isFirstColumnZero)
        {
            for(int i = 0; i < matrix[0].length; i++)
            {
                matrix[0][i] = 0;
            }
        }
    }
}
