package leetcode.sotsearch;

/**
 * When there are duplicates
 * @author Gowrav Deivasigamani
 */
public class FindMinimumInRotatedSortedArrayII
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] ia = {4, 1, 2, 5, 6};
        System.out.println(findMin(ia));
    }

    public static int findMin(int[] nums)
    {
        int left = 0, right = nums.length - 1;
        while(left < right)
        {
            if(nums[left] < nums[right])
                break;
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right])
            {
                left = mid + 1;
            }
            else if(nums[mid] < nums[right])
            {
                right = mid;
            }
            else
            {
                right--;
            }
        }
        return nums[left];
    }

}
