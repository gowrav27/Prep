package com.blogspot.aknowakowski.jodaTime.dynamicProgramming;

public class Lis
{

    public static void main(String[] args)
    {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of lis is " + list(arr) + "n");
    }

    private static int list(int[] a)
    {
        int max = 0;
        for(int i = 0; i < a.length; i++)
        {
            int len = list(a, a[i], i);
            if(len > max)
            {
                max = len;
            }
        }
        return max + 1;
    }

    private static int list(int[] a, int lastElement, int index)
    {
        if(index == a.length)
        {
            return 0;
        }
        int t1 = 0;
        if(a[index] > lastElement)
        {
            t1 = 1 + list(a, a[index], index + 1);
        }
        int t2 = list(a, lastElement, index + 1);
        return Math.max(t1, t2);
    }
}
