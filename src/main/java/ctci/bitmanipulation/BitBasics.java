package ctci.bitmanipulation;

// https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary:-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
public class BitBasics
{

    public static void main(String[] args)
    {

        // int x = -93242;
        // int count = 40;
        // repeatedArithmeticShift(x, count);
        System.out.println(0 << 1);
    }

    static int repeatedArithmeticShift(int x, int count)
    {
        for(int i = 0; i < count; i++)
        {
            x = x >> 1;
            System.out.println(x);
        }
        return x;
    }
}
