package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement1
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] ia = {1, 1, 2, 2, 2, 2, 3, 3};
        System.out.println("Sort:" + majorityElement1(ia));
        System.out.println("Hashtable:" + majorityElement2(ia));
        System.out.println("Moore's alogo : " + majorityElement3(ia));
        System.out.println("Bit :" + majorityElement(ia));
        
    }

 // Sorting
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Hashtable 
    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
        int ret=0;
        for (int num: nums) {
            if (!myMap.containsKey(num))
                myMap.put(num, 1);
            else
                myMap.put(num, myMap.get(num)+1);
            if (myMap.get(num)>nums.length/2) {
                ret = num;
                break;
            }
        }
        return ret;
    }

    // Moore voting algorithm
    public static int majorityElement3(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0)
                ret = num;
            if (num!=ret)
                count--;
            else
                count++;
        }
        return ret;
    }

    // Bit manipulation 
    public  static int majorityElement(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums)
            for (int i=0; i<32; i++) 
                if ((num>>(31-i) & 1) == 1)
                    bit[i]++;
        int ret=0;
        for (int i=0; i<32; i++) {
            bit[i]=bit[i]>nums.length/2?1:0;
            ret += bit[i]*(1<<(31-i));
        }
        return ret;
    }
}
