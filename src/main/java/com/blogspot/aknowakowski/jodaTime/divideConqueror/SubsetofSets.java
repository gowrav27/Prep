package com.blogspot.aknowakowski.jodaTime.divideConqueror;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetofSets
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] s = {1, 2, 3};
        System.out.println(subsets(s));
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] S)
    {
        if(S == null)
            return null;
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int element : S)
        {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            // get sets that are already in result
            for(ArrayList<Integer> a : result)
            {
                temp.add(new ArrayList<Integer>(a));
            }
            // add S[i] to existing sets
            for(ArrayList<Integer> a : temp)
            {
                a.add(element);
            }
            // add S[i] only as a set
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(element);
            temp.add(single);
            result.addAll(temp);
        }
        // add empty set
        result.add(new ArrayList<Integer>());
        return result;
    }
}
