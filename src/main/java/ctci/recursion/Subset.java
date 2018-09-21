package ctci.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        subset(nums, 0, list, lists);
        System.out.println(lists);
    }

    private static void subset(List<Integer> nums, int curr, List<Integer> list, List<List<Integer>> lists)
    {
        if(!list.isEmpty())
        {
            lists.add(new ArrayList(list));
        }
        if(curr >= nums.size())
        {
            return;
        }

        for(int i = curr; i < nums.size(); i++)
        {
            list.add(nums.get(i));
            subset(nums, i + 1, list, lists);
            int last = list.size() - 1;
            list.remove(last);

        }

    }
}
