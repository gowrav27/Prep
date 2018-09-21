package com.blogspot.aknowakowski.jodaTime;

import java.util.Arrays;

// https://raw.githubusercontent.com/ozelentok/CodingBat-Solutions/master/Java/Recursion-2.java
public class groupSum6
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] n = {3, 5, 8};
        System.out.println(split53(n));
    }

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, beginning at
     * the start index, such that the group sums to the given target? However, with the additional
     * constraint that all 6's must be chosen. (No loops needed.) groupSum6(0, [5, 6, 2], 8) true
     * groupSum6(0, [5, 6, 2], 9) false groupSum6(0, [5, 6, 2], 7) false
     * @param start
     * @param nums
     * @param target
     * @return
     */
    public static boolean groupSum6(int start, int[] nums, int target)
    {
        if(start == nums.length)
        {
            if(target == 0)
                return true;
            return false;
        }
        if(nums[start] == 6)
            return groupSum6(start + 1, nums, target - nums[start]);
        if(groupSum6(start + 1, nums, target - nums[start]))
            return true;
        return groupSum6(start + 1, nums, target);
    }

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the
     * group sums to the given target with this additional constraint: If a value in the array is
     * chosen to be in the group, the value immediately following it in the array must not be
     * chosen. (No loops needed.) groupNoAdj(0, [2, 5, 10, 4], 12) true groupNoAdj(0, [2, 5, 10, 4],
     * 14) false groupNoAdj(0, [2, 5, 10, 4], 7) false
     * @param start
     * @param nums
     * @param target
     * @return
     */
    public boolean groupNoAdj(int start, int[] nums, int target)
    {

        if(target == 0)
            return true;
        if(start >= nums.length)
        {
            return false;
        }

        if(groupNoAdj(start + 2, nums, target - nums[start]))
        {
            return true;
        }
        if(start + 1 >= nums.length)
        {
            return false;
        }
        if(groupNoAdj(start + 3, nums, target - nums[start + 1]))
            return true;
        return false;
    }

    // alernate for above
    public boolean groupNoAdj2(int start, int[] nums, int target)
    {
        if(target == 0)
            return true;
        if(start >= nums.length)
            return false;
        if(groupNoAdj(start + 2, nums, target - nums[start]))
            return true;
        return groupNoAdj(start + 1, nums, target);
    }

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the
     * group sums to the given target with these additional constraints: all multiples of 5 in the
     * array must be included in the group. If the value immediately following a multiple of 5 is 1,
     * it must not be chosen. (No loops needed.) groupSum5(0, [2, 5, 10, 4], 19) true groupSum5(0,
     * [2, 5, 10, 4], 17) true groupSum5(0, [2, 5, 10, 4], 12) false
     * @param start
     * @param nums
     * @param target
     * @return
     */
    public boolean groupSum5(int start, int[] nums, int target)
    {
        if(start >= nums.length)
        {
            if(target == 0)
                return true;
            return false;
        }
        if(nums[start] % 5 == 0)
        {
            if(start < nums.length - 1 && nums[start + 1] == 1)
                return groupSum5(start + 2, nums, target - nums[start]);
            return groupSum5(start + 1, nums, target - nums[start]);
        }
        if(groupSum5(start + 1, nums, target - nums[start]))
            return true;
        return groupSum5(start + 1, nums, target);
    }

    public boolean splitArray(int[] nums) {
        int[] array2 =new int[nums.length];
        return splitArrayHelper(nums, nums.length-1, array2, 0);
    }

    private boolean splitArrayHelper(int[] array1, int endArray1, int[] array2, int startArray2)
    {
         if(array1EqualsArray2(array1, array2)){
            return true;
        }
        if(endArray1 <= 0 && startArray2 >= array2.length){
            return false;
        }
        array2[startArray2] = array1[endArray1];
        array1[endArray1] = 0;
        if(splitArrayHelper(array1,  endArray1 -1, array2,  startArray2+1)){
            return true;
        }
        
        array1[endArray1] = array2[startArray2];
        array2[startArray2] = 0;
        return splitArrayHelper(array1,  endArray1 -1, array2,  startArray2+1);
    }

    
    
    public boolean splitOdd10(int[] nums) {
        int[] array2 =new int[nums.length];
        return splitArrayHelper2(nums, nums.length-1, array2, 0);
    }
    
    private boolean splitArrayHelper2(int[] array1, int endArray1, int[] array2, int startArray2)
    {
         if((arraySum(array1)%10 == 0 && arraySum(array2)% 2 == 1) || (arraySum(array2)%10 == 0 && arraySum(array1)% 2 == 1) ){
            return true;
        }
        if(endArray1 <= 0 && startArray2 >= array2.length){
            return false;
        }
        array2[startArray2] = array1[endArray1];
        array1[endArray1] = 0;
        if(splitArrayHelper2(array1,  endArray1 -1, array2,  startArray2+1)){
            return true;
        }
        
        array1[endArray1] = array2[startArray2];
        array2[startArray2] = 0;
        return splitArrayHelper2(array1,  endArray1 -1, array2,  startArray2+1);
    }
    public static boolean split53(int[] nums) {
        int[] array2 =new int[nums.length];
        return splitArrayHelper3(nums, nums.length-1, array2, 0);
    }
    
    private static boolean splitArrayHelper3(int[] array1, int endArray1, int[] array2, int startArray2)
    {
        
        if(endArray1 <= 0 && startArray2 >= array2.length){
            if(array1EqualsArray2(array1, array2) ==  true){
                return true;
            }
            return false;
        }
        if(array1[endArray1] % 5 == 0){
            return splitArrayHelper3(array1,  endArray1 -1, array2,  startArray2+1);
            
        }
        if(array1[endArray1] % 3 == 0 && array1[endArray1] % 5 != 0){
            array2[startArray2] = array1[endArray1];
            array1[endArray1] = 0;
            return splitArrayHelper3(array1,  endArray1 -1, array2,  startArray2+1);
            
        }
        
        array2[startArray2] = array1[endArray1];
        array1[endArray1] = 0;
     
        if(splitArrayHelper3(array1,  endArray1 -1, array2,  startArray2+1)){
            return true;
        }
        
        array1[endArray1] = array2[startArray2];
        array2[startArray2] = 0;
        return splitArrayHelper3(array1,  endArray1 -1, array2,  startArray2+1);
    }
    
    private static boolean array1EqualsArray2(int[] array1, int[] array2)
    {
         return arraySum(array1) == arraySum(array2);      
    }
    
    private static int arraySum(int[] array){
        int arraySum= 0;
        for(int i = 0; i< array.length; i++){
            arraySum += array[i];
        }
        return arraySum;
    }

}
