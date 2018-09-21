package leetcode.binarySearchTrees;

public class UniqueBinarySearchTrees
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(number(3));
    }

    public static int number(int n)
    {
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;

        int result[] = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        if(n < 3)
        {
            return result[n];
        }

        for(int i = 3; i <= n; i++)
        {
            for(int k = 1; k <= i; k++)
            {

                result[i] = result[i] + result[k - 1] * result[i - k];
            }
        }

        return result[n];
    }

}
