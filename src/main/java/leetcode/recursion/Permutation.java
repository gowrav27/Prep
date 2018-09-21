package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String s = "123";
        System.out.println(premute(s));
    }

    public static List<String> premute(String s){
        List<String> list = new ArrayList<String>();
        premute(list, s, "", s.length());
        return list;
    }

    private static void premute(List<String> list, String orgString, String permtueString, int len)
    {
        if(orgString.isEmpty()){
            list.add(permtueString);
            return;
        }
        for(int i=0;i<orgString.length();i++){
            String sTemp;
            if(i==0){
                sTemp = orgString.substring(i+1);
            }else{
                sTemp = orgString.substring(0, i)+ orgString.substring(i+1);
            }
            premute(list, sTemp, permtueString+orgString.charAt(i), len);
        }
        //tail
    }
}
