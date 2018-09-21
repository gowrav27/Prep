package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println( generate(4));
    }

    public static List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> lists = new  ArrayList<List<Integer>>();
        for(int i=0 ;i< numRows;i++){
            List<Integer> newList = new ArrayList<Integer>();
            lists.add(newList);
        }
        return generate(lists, numRows, 0);
    }

    private static List<List<Integer>> generate(List<List<Integer>> lists, int numRows, int i)
    {
        if(i == numRows){
            return lists;
        }
        if(i == 0){
            lists.get(i).add(1);
            return generate(lists, numRows, i+1);
        }else{
            List<Integer> prevList = lists.get(i-1);
            List<Integer> currList = lists.get(i);
            for(int j = 0; j < i+1;j++){
                if(j==0 || j== i){
                    currList.add(prevList.get(0));
                }else{
                    Integer value = prevList.get(j-1) + prevList.get(j);
                    currList.add(value);
                }
                
            }
            return generate(lists, numRows, i+1);
        }
    }
}
