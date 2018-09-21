package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
//        String s = "25525511135"; // ["255.255.11.135", "255.255.111.35"]
        String s = "25524";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s)
    {
        List<String> res = new ArrayList<String>();
        helper(s, "", res, 0);
        return res;
    }

    public static void helper(String s, String tmp, List<String> res, int n)
    {
        if(n == 4)
        {
            if(s.length() == 0)
            {
                res.add(tmp.substring(0, tmp.length() - 1));
            }
            // substring here to get rid of last '.'
            return;
        }
        for(int k = 1; k <= 3; k++)
        {
            if(s.length() < k)
            {
                continue;
            }
            int val = Integer.parseInt(s.substring(0, k));
            if(val > 255 || k != String.valueOf(val).length())
            {
                continue;
            }
            /*in the case 010 the parseInt will return len=2 where val=10, but k=3, skip this.*/
            helper(s.substring(k), tmp + s.substring(0, k) + ".", res, n + 1);
        }
    }
}
