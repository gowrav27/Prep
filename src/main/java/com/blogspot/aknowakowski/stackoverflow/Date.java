package com.blogspot.aknowakowski.stackoverflow;

public class Date
{

    public static void main(String[] args)
    {
        // new DateTime(new Date(), DateTimeZone.forTimeZone(TimeZone.getDefault()));
        test("s", "s");
    }

    private static void test(String a, String b)
    {
        if((a == null ^ b == null) || (a.length() != b.length()))
        {
            // not equal
            System.out.println("not equal");
        }
    }
}
