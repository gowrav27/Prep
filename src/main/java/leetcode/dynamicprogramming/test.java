package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test
{
    static int many = 0;

    public static void main(String[] args)
    {
        String[] strs = {"abc", "abd", "ab"};
        Arrays.sort(strs);
        System.out.println(strs.toString());
        // TODO Auto-generated method stub
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
//        10, 9, 2, 5, 3, 4};
        System.out.println(lengthOfLIS(arr));
        System.out.println(Math.pow(0, 3));
    }

    public static int lengthOfLIS(int[] nums)
    {
        if(nums.length == 0)
        {
            return 0;
        }
        if(nums.length == 1)
        {
            return 1;
        }
        Map<Pair, Integer> map = new HashMap<Pair, Integer>();
        return lengthOfLIS(nums, 0, Integer.MIN_VALUE, 0, map);
    }

    public static int lengthOfLIS(int[] nums, int index, int prev, int count, Map<Pair, Integer> map)
    {
        many++;
        if(index == nums.length)
        {
            return count;
        }
        Integer mapValue = map.get(new Pair(prev, index));
        if(mapValue != null)
        {
            return mapValue;
        }
        int withValue = 0;
        if(prev < nums[index])
        {
            withValue = lengthOfLIS(nums, index + 1, nums[index], count + 1, map);
        }
        int withoutValue = 0;
        withoutValue = lengthOfLIS(nums, index + 1, prev, count, map);
        map.put(new Pair(prev, index), Integer.valueOf(Math.max(withValue, withoutValue)));
        return Math.max(withValue, withoutValue);
    }
}

class  Pair{
    int prev = 0;
    int index = 0;
    Pair(int prev, int index){
        this.prev = prev;
        this.index = index;
    }

    @Override
    public boolean equals(Object obj)
    {
        Pair arg = (Pair) obj;
        return this.prev == arg.prev && this.index == arg.index;
    }
}
