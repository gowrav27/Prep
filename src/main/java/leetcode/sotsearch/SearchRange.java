package leetcode.sotsearch;

// https://leetcode.com/problems/search-for-a-range/description/
public class SearchRange
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    public static int[] searchRange(int[] nums, int target)
    {
        int start = -1;
        int end = -1;
        start = findFirst(nums, target, 0, nums.length - 1);
        end = findLast(nums, target, 0, nums.length - 1);
        return new int[] {start, end};

    }

    private static int findFirst(int[] nums, int target, int start, int end)
    {
        int first = -1;
        while(start <= end)
        {
            int curr = binarySearch(nums, target, start, end);
            if(curr == -1)
            {
                break;
            }
            first = curr;
            end = curr - 1;
        }
        return first;
    }

    private static int findLast(int[] nums, int target, int start, int end)
    {
        int last = -1;
        while(start <= end)
        {
            int curr = binarySearch(nums, target, start, end);
            if(curr == -1)
            {
                break;
            }
            last = curr;
            start = curr + 1;
        }
        return last;
    }

    private static int binarySearch(int[] nums, int target, int start, int end)
    {
        if(start > end)
        {
            return -1;
        }
        int mid = (start + end) / 2;
        int midValue = nums[mid];
        if(midValue == target)
        {
            return mid;
        }
        if(midValue > target)
        {
            return binarySearch(nums, target, start, mid - 1);
        }
        else
        {
            return binarySearch(nums, target, mid + 1, end);
        }
    }
}
