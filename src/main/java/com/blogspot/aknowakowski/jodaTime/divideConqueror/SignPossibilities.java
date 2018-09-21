package com.blogspot.aknowakowski.jodaTime.divideConqueror;

import java.util.Arrays;

public class SignPossibilities
{
    public static void main (String[] args)
    {
        int[] nums = {1, 2, 3};
        int[] sign = {0};
        int val =3;
        int res = 3;
        System.out.println(poss(nums, sign, val ,3));
    }
    
    private static int poss(int nums[], int[] sign,  int val, int res){
        if(val == res){
            return 1;
        }
//        if(val < 0){
//            return 0;
//        }
        
        int i=0;
        int count = 0;
        while(i < nums.length){
            
//            int temp = val - nums[i];
//            count = count + poss(Arrays.copyOfRange(nums, i+1, nums.length) , sign, temp);
            for(int j=0; j< sign.length;j++){
                int temp = oper(val, nums[i], sign[i]);
                //int temp = val - nums[i];
                count = count + poss(Arrays.copyOfRange(nums, i+1, nums.length) , sign, temp, res);
            }
            i++;
        }

        return count;
    }
    
    private static int oper(int a, int b, int operator){
        switch(operator){
            case 0:
                return a+b;
            case 1:
                return a-b;
            
        }
        return operator;
    }
}
