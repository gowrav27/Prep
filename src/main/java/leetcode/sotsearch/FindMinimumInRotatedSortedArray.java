package leetcode.sotsearch;

public class FindMinimumInRotatedSortedArray
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] ia = {3, 1};
        System.out.println("Correct version : " + findMin1(ia));
    }



    public static int findMin1(int[] nums)
    {
        int left = 0, right = nums.length - 1;
        while(left < right)
        {
            if(nums[left] < nums[right])
                break;
            int mid = (left + right) / 2;
            // notice the change in check in here and in other normal binary search
            if(nums[mid] > nums[right])
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        return nums[left];
    }
}
