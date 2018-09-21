package leetcode.dynamicprogramming;

public class ReverseNumbers
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(reverse(123));
    }

    public static int reverse(int x)
    {
        int result = 0;

        while(x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if(Math.abs(result) > Integer.MAX_VALUE / 10)
            {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
