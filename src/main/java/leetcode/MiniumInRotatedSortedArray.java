package leetcode;

public class MiniumInRotatedSortedArray
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] nums = {2, 1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums)
    {
        return findMin(nums, 0, nums.length - 1);
    }

    private static int findMin(int[] nums, int start, int end)
    {
        if(start > end)
        {
            return -1;
        }
        int mid = (start + end) / 2;
        if(nums[start] < nums[mid - 1] && nums[mid + 1] > nums[end])
        {
            return findMin(nums, mid + 1, end);
        }

        if(nums[start] > nums[mid - 1] && nums[mid + 1] < nums[end])
        {
            return findMin(nums, start, mid - 1);
        }

        return nums[mid];
    }
    public int findPeakElement(int[] nums)
    {
        return findPeakElement(nums, 0, nums.length);
    }
    public int findPeakElement(int[] nums, int start, int end)
    {
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
   
            if(nums[start] < nums[mid] &&  nums[mid] < nums[end])
            {
                return mid;
            }
            int val = 0;
            
            val = findPeakElement(nums, start, mid-1);
            if(val != 0){
               return val; 
            }
            else{
                val = findPeakElement(nums, mid+1, end);
            }
            return findPeakElement(nums, mid+1, end);
    }
}
