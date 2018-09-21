package leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String s = "234";
        System.out.println(letterCombinations(s));
    }

    public static List<String> letterCombinations(String digits)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        
        List<String> res = new ArrayList<String>();
        
        letterCombinations(res, digits, map);
        return res;
    }

    private static void letterCombinations(List<String> res, String digits, Map<String, String> map)
    {
        if(digits.length() == 0){
            return ;
        }
        if(res.isEmpty()){
           String firstChar =  digits.substring(0, 1);
           String phoneLetter = map.get(firstChar);
           
           for(int i=0; i< phoneLetter.length();i++){
               res.add(String.valueOf(phoneLetter.charAt(i)));
           }
           letterCombinations(res, digits.substring(1), map);
           return;
           
        }
        int initialSize = res.size();
        for(int i=0;i<initialSize;i++){
            String list = res.get(i);
            String firstChar =  digits.substring(0, 1);
            String phoneLetter = map.get(firstChar);
            
            for(int j=0; j< phoneLetter.length();j++){
                String temp = list + String.valueOf(phoneLetter.charAt(j));
                res.add(temp);
            }
            
        }
        while(initialSize > 0){
            res.remove(0);
            initialSize--;
        }
        
        letterCombinations(res, digits.substring(1), map);
        return;
    }
}
