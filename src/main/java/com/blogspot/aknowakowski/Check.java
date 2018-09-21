package com.blogspot.aknowakowski;

public class Check
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        // validateId(null);
        // int n = 00001000;
        // int m = 111;
        // System.out.println(updateBits(n, m, 0, 2));
        // String s = "bc";
        // int i = s.charAt(0);
        // System.out.println(i);
        // System.out.println(reverse("cabtn"));
        char[] c = {'a', 'b', 'b', 'c', ' ', 'c'};
        String s = "df j";
        ReplaceFun(s.toCharArray(), 4);
        System.out.println(c);

    }

    public static void ReplaceFun(char[] str, int length)
    {
        int spaceCount = 0, newLength, i = 0;
        for(i = 0; i < length; i++)
        {
            if(str[i] == ' ')
            {
                spaceCount++;
            }
        }
        newLength = length + spaceCount * 2;
        str[newLength--] = '\0';
        for(i = length - 1; i >= 0; i--)
        {
            if(str[i] == ' ')
            {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else
            {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        System.out.println(str);
    }

    public static void removeDuplicates(char[] str)
    {
        if(str == null)
            return;
        int len = str.length;
        if(len < 2)
            return;

        int tail = 1;

        for(int i = 1; i < len; ++i)
        {
            int j;
            for(j = 0; j < tail; ++j)
            {
                if(str[i] == str[j])
                    break;
            }
            if(j == tail)
            {
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;
    }

    private static String reverse(String s)
    {
        int len = s.length();
        char[] c = s.toCharArray();
        for(int i = 0, j = len - 2; i < j; i++, j--)
        {
            char temp = c[j];
            c[j] = c[i];
            c[i] = temp;
        }
        return new String(c);
    }

    private static void validateId(Long id)
    {
        System.out.println(9 >> 36);
        System.out.println(-9 >>> 2);
        int n = Integer.parseInt("101", 2);
        System.out.println(n);
        int m = ~0;
        System.out.println(m);
    }

    public static int updateBits(int n, int m, int i, int j)
    {
        int max = ~0; /* All 1’s */

        // 1’s through position j, then 0’s
        int left = max - ((1 << j) - 1);

        // 1’s after position i
        int right = ((1 << i) - 1);

        // 1’s, with 0s between i and j
        int mask = left | right;

        // Clear i through j, then put m in there
        return (n & mask) | (m << i);
    }
}
