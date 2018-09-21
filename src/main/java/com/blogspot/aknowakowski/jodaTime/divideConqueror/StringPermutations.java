package com.blogspot.aknowakowski.jodaTime.divideConqueror;

import java.util.ArrayList;
import java.util.List;

// http://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html
public class StringPermutations
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        List<String> s = new ArrayList<String>();
        permute("", "abc", s);
        System.out.println(s);
        permutation("", "abc");

    }

    private static List<String> permute(String soFar, String rem, List<String> s)
    {
        if(rem.isEmpty())
        {
            s.add(soFar);
            return s;
        }
        for(int i = 0; i < rem.length(); i++)
        {
            permute(soFar + rem.charAt(i), rem.substring(0, i) + rem.substring(i + 1), s);
        }
        return s;
    }

    private static void permutation(String perm, String word)
    {
        if(word.isEmpty())
        {
            System.err.println(perm + word);
        }
        else
        {
            for(int i = 0; i < word.length(); i++)
            {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

}
