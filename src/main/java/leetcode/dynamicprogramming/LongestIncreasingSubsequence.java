package leetcode.dynamicprogramming;

public class LongestIncreasingSubsequence
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] arr = {10, 9, 1, 2, 3, 4, 5};
        System.out.println(lengthOfLIS(arr));
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
        return lengthOfLIS(nums, 0, Integer.MIN_VALUE, 0);
    }

    public static int lengthOfLIS(int[] nums, int index, int prev, int count)
    {
        if(index == nums.length)
        {
            return count;
        }
        int withValue = 0;
        if(prev < nums[index])
        {
            withValue = lengthOfLIS(nums, index + 1, nums[index], count + 1);
        }
        int withoutValue = 0;
        withoutValue = lengthOfLIS(nums, index + 1, prev, count);

        return Math.max(withValue, withoutValue);
    }
}
