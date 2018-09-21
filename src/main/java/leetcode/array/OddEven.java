package leetcode.array;

import java.util.Arrays;

public class OddEven
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] nums = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10};
        int[] nums1 = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10};
        oddEvenRelativeOrder(nums);
        System.out.println(Arrays.toString(nums));
        rearrange(nums1, nums.length);
        System.out.println(Arrays.toString(nums1));
    }

    public static void rearrange(int a[], int size)
    {
        int positive = 0, negative = 1, temp;

        while(true)
        {

            /* Move forward the positive pointer till
            negative number number not encountered */
            while(positive < size && a[positive] >= 0)
                positive += 2;

            /* Move forward the negative pointer till
            positive number number not encountered */
            while(negative < size && a[negative] <= 0)
                negative += 2;

            // Swap array elements to fix their position.
            if(positive < size && negative < size)
            {
                temp = a[positive];
                a[positive] = a[negative];
                a[negative] = temp;
            }

            /* Break from the while loop when any index
            exceeds the size of the array */
            else
                break;
        }
    }

    public static void oddEvenRelativeOrder(int[] nums)
    {
        if(nums.length < 2)
        {
            return;
        }
        int positive = 0;
        int negative = 1;
        while(negative < nums.length && positive < nums.length)
        {
            while(negative < nums.length && nums[negative] < 0)
            {
                negative = negative + 2;
            }
            while(positive < nums.length && nums[positive] >= 0)
            {
                positive = positive + 2;
            }
            if(negative < nums.length && positive < nums.length)
            {
                int temp = nums[positive];
                nums[positive] = nums[negative];
                nums[negative] = temp;
            }
            positive = positive + 2;
            negative = negative + 2;
        }
    }
    public static void oddEven3(int[] nums)
    {
        if(nums.length < 2)
        {
            return;
        }
        int odd = 1;
        int even = 0;
        while(odd < nums.length && even < nums.length)
        {
            while(odd < nums.length && nums[odd] % 2 != 0)
            {
                odd = odd + 2;
            }
            while(even < nums.length && nums[even] % 2 == 0)
            {
                even = even + 2;
            }
            if(odd < nums.length && even < nums.length)
            {
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
            }
            odd = odd + 2;
            even = even + 2;
        }
    }

    public static void oddEven2(int[] nums)
    {
        if(nums.length < 2)
        {
            return;
        }
        int i = 0;
        int j = nums.length - 1;
        while(i < j)
        {
            while(i < nums.length && nums[i] % 2 == 0)
            {
                i++;
            }
            while(j > 0 && nums[j] % 2 != 0)
            {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static int[] oddEven(int[] nums)
    {
        if(nums.length == 1)
        {
            return nums;
        }
        int len = nums.length;
        int j = len - 1;
        int i = 0;
        while(i < j)
        {
            while(nums[i] % 2 == 0 && i < j)
            {
                i++;
            }
            while(nums[j] % 2 != 0 && i < j)
            {
                j--;
            }
            if(i < j)
            {

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }

}
