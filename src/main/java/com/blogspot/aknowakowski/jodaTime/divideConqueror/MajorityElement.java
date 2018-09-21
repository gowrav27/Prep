package com.blogspot.aknowakowski.jodaTime.divideConqueror;

import java.util.Arrays;

public class MajorityElement
{

    public static void main(String[] args)
    {
       int[] a = {5, 5, 5,4,5,5,7,3,7};
       System.out.println(majorityElement(a));

    }
//
//    public static int  majorityElement(int[] nums)
//    {
//        Arrays.sort(nums);
//        System.out.println(nums);
//        return 5;
//    }

    public static int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
}
