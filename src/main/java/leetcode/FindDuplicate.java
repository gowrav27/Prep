package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-duplicate-number/description/
public class FindDuplicate
{
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 2};
        System.out.println(findDuplicate(nums));

    }

    public static int findDuplicate(int[] nums)
    {
        Arrays.sort(nums);
        while(true)
        {
            System.out.println("fff");
        }
        // for(int i = 1; i < nums.length; i++)
        // {
        // if(num == nums[i])
        // {
        // num = nums[i];
        // break;
        // }
        // num = nums[i];
        // }
        // return num;
    }

}
