package leetcode.array;

public class LongestContinuousIncreasingSubsequence
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] nums = {1,3,5,4,2,3,4,5};
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums)
    {
        if(nums.length == 0){
            return 0;
        }
        int max = 1;
        int maxSoFar = 1;
        
        for(int i=1; i< nums.length;i++){
            if(nums[i-1] < nums[i]){
                maxSoFar++;
            }else{
                maxSoFar = 1;
            }
            
            if(max < maxSoFar){
                max = maxSoFar;
            }
        }
        return max;
    }
}
