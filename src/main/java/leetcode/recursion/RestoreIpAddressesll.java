package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddressesll
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String s = "25524"; // ["255.255.11.135", "255.255.111.35"]
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s)
    {
        List<String> res = new ArrayList<String>();
        helper(res, s, 0, "");
        return res;
    }

    private static void helper(List<String> res, String s, int dots, String ip)
    {
        if(dots == 4)
        {
            if(s.length() == 0)
            {
             
                    res.add(ip.substring(0, ip.length() - 1));
                
            }
            return;
        }
        for(int k = 1; k <= 3; k++)
        {
            if(k > s.length())
            {
                continue;
            }
            String temp = s.substring(0, k);
            Integer val = Integer.parseInt(temp);
            if(val > 255)
            {
                continue;
            }
            if(k!= String.valueOf(val).length()){
                continue;
            }
            helper(res, s.substring(k), dots + 1, ip + String.valueOf(val) + ".");
        }
    }

}
