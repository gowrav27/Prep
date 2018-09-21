package leetcode.array;

public class LongestIncreasingSubsequence
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }
    public static int findLengthOfLCIS(int[] nums)
    {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        int maxSoFar = 1;
        
        for(int i=1; i< nums.length;i++){
            if(nums[i-1] < nums[i]){
                dp[i] = dp[i-1] +1;
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
