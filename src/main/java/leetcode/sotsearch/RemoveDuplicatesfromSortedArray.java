package leetcode.sotsearch;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] ia = {1, 1, 2, 2, 2, 3};
        System.out.println(removeDuplicates(ia));
        System.out.println(Arrays.toString(ia));
    }

    public static int removeDuplicates(int[] nums)
    {
        if(nums.length <= 1)
        {
            return 1;
        }
        int i = 0;
        int j = 1;
        int len = nums.length;
        while(j < len)
        {
            if(nums[i] == nums[j])
            {
                while(j < len && nums[j] == nums[i])
                {
                    j++;
                }
            }
            if(j >= nums.length)
            {
                return i + 1;
            }
            i++;
            nums[i] = nums[j];
            j++;
        }
        return i + 1;
    }
}
