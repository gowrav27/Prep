package leetcode.array;

public class ProductofArrayExceptSelf
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] nums = {1, 2, 3, 4};
        int[] nums2 = productExceptSelf(nums);
        System.out.println(nums2);
        System.out.println(Math.log10(9) / Math.log10(3));

    }

    public static int[] productExceptSelf(int[] nums)
    {
        int[] result = new int[nums.length];
        for(int i = 0, tmp = 1; i < nums.length; i++)
        {
            result[i] = tmp;
            tmp = tmp * nums[i];
        }
        for(int i = nums.length - 1, tmp = 1; i >= 0; i--)
        {
            result[i] = result[i] * tmp;
            tmp = tmp * nums[i];
        }
        return result;
    }
}
