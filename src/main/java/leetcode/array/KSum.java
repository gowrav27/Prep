package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
//        int[] ia = {1, 0, -1, 0, -2, 2};
        int[] ia = {-2, -1, 0, 0, 1, 2};
        System.out.println(fourSum(ia, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int k = 4;
        return KSum(lists, nums, target, 0, nums.length - 1, 4);
    }

    private static List<List<Integer>> KSum(List<List<Integer>> lists, int[] nums, int target, int start, int end, int k)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k == 2)
        {
            int i=start;
            int j = end;
            while(i<j){
                int val = nums[i] + nums[j];
                List<Integer> list = new ArrayList<Integer>();
                if(val == target)
                {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(new ArrayList<Integer>(list));
                    
                    i++;
                    j--;
                    while(i < j && i!=0 && nums[i] == nums[i-1]){
                        i++;
                    }
                    while(i < j && j!=nums.length-1 && nums[j] == nums[j+1]){
                        j--;
                    }
                }else if(val <  target){
                    i++;
                }else{
                    j--;
                }                          
            }
        }
        else
        {
            for(int i = start; i <= nums.length-(k-1);i++ ){
                if(i <= nums.length && i>start && nums[i] == nums[i-1]){
                   continue;
                }
                List<List<Integer>> temp = KSum(lists, nums, target-nums[i], i+1, end, k-1);
                for(List<Integer> t : temp){
                    t.add(0, nums[i]);
                }
                result.addAll(new ArrayList<List<Integer>>(temp));
            }
        }
        return result;
    }
}
