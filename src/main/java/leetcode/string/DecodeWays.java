package leetcode.string;

public class DecodeWays
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(numDecodings("12222"));
        System.out.println(numDecodings2("12345"));
    }

    private static int numWays(String s, int index)
    {
        if(index == s.length())
            return 1;
        if(index > s.length())
            return 0;

        int ways = 0;
        if(s.charAt(index) - '0' > 0)
            ways += numWays(s, index + 1);

        if(index + 1 < s.length())
        {
            if(s.charAt(index) - '0' == 1)
                ways += numWays(s, index + 2);
            else if(s.charAt(index) - '0' == 2 && s.charAt(index + 1) - '0' <= 6)
                ways += numWays(s, index + 2);
        }
        return ways;
    }

    public static int numDecodings(String s)
    {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++)
        {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if(first >= 1 && first <= 9)
            {
                dp[i] += dp[i - 1];
            }
            if(second >= 10 && second <= 26)
            {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static int numDecodings2(String s) {
        if (s.isEmpty())
            return 0;
        return numWays(s, 0);
    }



}

