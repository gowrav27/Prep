package ctci.recursion;

public class CountSteps
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int n = 15;

        System.out.println(count(n, 0));
        System.out.println(countWays(n));
        System.out.println(count2(n));
    }

    private static int count(int n, int indx)
    {
        if(indx > n)
        {
            return 0;
        }
        if(indx == n)
        {
            return 1;
        }
        int c = 0;
        c += count(n, indx + 1);
        c += count(n, indx + 2);
        c += count(n, indx + 3);
        return c;
    }

    static int countWays(int n)
    {
        if(n < 0)
        {
            return 0;
        }
        else if(n == 0)
        {
            return 1;
        }
        else
        {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    private static int count2(int n)
    {
        int[] mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        mem[3] = 4;
        for(int i = 4; i <= n; i++)
        {
            mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3];
        }

        return mem[n];
    }
}
