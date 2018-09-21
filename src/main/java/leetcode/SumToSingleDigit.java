package leetcode;

public class SumToSingleDigit
{
    public static void main(String[] args)
    {
        System.out.println(sum1(567));
        System.out.println(digSum(567));
    }

    static int sum1(int sum)
    {
        while(sum > 9)
        {
            sum = sum(sum);
        }
        return sum;
    }

    static int sum(int num)
    {
        int sum = 0;
        while(num > 9)
        {
            sum = sum + (num % 10);
            num = num / 10;
        }
        sum = sum + num;
        return sum;
    }

    static int digSum(int n)
    {
        int sum = 0;

        // Loop to do sum while
        // sum is not less than
        // or equal to 9
        while(n > 0 || sum > 9)
        {
            if(n == 0)
            {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
