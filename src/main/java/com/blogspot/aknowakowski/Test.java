package com.blogspot.aknowakowski;

public class Test
{

    public static void main(String[] args)
    {
        // TODO Auto-generated/ method stub
        String s = "How? are you?";
        char[] ss = s.toCharArray();
        reverseWords(ss);
        System.out.println(ss);
    }

    public static String reverseWords(String s)
    {
        if(s == null)
            return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    static void reverseWords(char[] a, int n)
    {
        int i = 0, j = 0;

        while(i < n)
        {
            while(i < j || i < n && a[i] == ' ')
                i++; // skip spaces
            while(j < i || j < n && a[j] != ' ')
                j++; // skip non spaces
            reverse(a, i, j - 1); // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    static String cleanSpaces(char[] a, int n)
    {
        int i = 0, j = 0;

        while(j < n)
        {
            while(j < n && a[j] == ' ')
                j++; // skip spaces
            while(j < n && a[j] != ' ')
                a[i++] = a[j++]; // keep non spaces
            while(j < n && a[j] == ' ')
                j++; // skip spaces
            if(j < n)
                a[i++] = ' '; // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    static private void reverse(char[] a, int i, int j)
    {
        while(i < j)
        {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    static public void reverseWords(char[] s)
    {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse1(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        for(int i = 0; i < s.length; i++)
        {
            if(s[i] == ' ')
            {
                reverse1(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse1(s, start, s.length - 1);
    }

    static public void reverse1(char[] s, int start, int end)
    {
        while(start < end)
        {

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
