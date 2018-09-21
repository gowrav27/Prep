package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FindNMaxElementInArray
{
    public static int majorityElement(int[] num)
    {

        int major = num[0], count = 1;
        for(int i = 1; i < num.length; i++)
        {
            if(count == 0)
            {
                count++;
                major = num[i];
            }
            else if(major == num[i])
            {
                count++;
            }
            else{
                count--;
            }

        }
        return major;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k)
    {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            if(i > k)
                set.remove(nums[i - k - 1]);
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums)
    {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums)
        {
            if(!set.add(i))
            {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args)
    {
        int[] ia = {1, 1, 2, 2, 2, 3, 3};
        System.out.println("Third max is:" + majorityElement(ia));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        System.out.println("Third max is:" + containsNearbyDuplicate(ia, 3));
        for(int item : ia)
        {
            minHeap.add(item);
            maxHeap.add(item);
        }

        System.out.println("Min heap:");

        while(minHeap.size() != 0)
        {
            System.out.println(minHeap.poll());
        }

        System.out.println("Max heap:");
        while(maxHeap.size() != 0)
        {
            System.out.println(maxHeap.poll());
        }

        System.out.println("Third max is:" + thirdMax(ia));

    }

    public static int thirdMax(int[] nums)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });

        for(int item : nums)
        {
            maxHeap.add(item);
        }

        int count = 3;
        int result = 0;
        if(maxHeap.size() != 0 && maxHeap.size() < 3)
        {
            result = maxHeap.poll();
        }
        else
        {
            while(maxHeap.size() != 0 && count > 0)
            {
                int temp = maxHeap.poll();
                if(temp != result)
                {
                    result = temp;
                    count--;
                }
            }
        }
        return result;
    }
}
