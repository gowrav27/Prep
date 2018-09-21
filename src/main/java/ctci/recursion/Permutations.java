package ctci.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/discuss/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
public class Permutations
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String str = "aac";
        List<String> list = new ArrayList<String>();
        permute(str, "", list);
        System.out.println(list);
    }

    private static void permute(String str, String perm, List<String> list)
    {
        if(str.length() == 0)
        {
            list.add(perm);
            return;
        }
        for(int i = 0; i < str.length(); i++)
        {
            permute(str.substring(0, i) + str.substring(i + 1), perm + str.charAt(i), list);
        }
    }
}
