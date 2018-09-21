package leetcode.array;

public class FindPivotIndex
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] ia = {1, 7, 3, 6, 5, 6};
        System.out.println("pivotIndex :" + pivotIndex(ia));
        System.out.println("pivotIndex :" + pivotIndex2(ia));
    }

    public  static int pivotIndex(int[] nums)
    {
        
       return pivotIndex(nums, 0, nums.length-1,0);
    }
    
    private static int pivotIndex2(int[] nums){
        
        for(int i =0;i<nums.length;i++){
            int leftSum = sum(nums, 0, i-1); 
            int rightSum = sum(nums, i+1, nums.length-1);
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
    
    private static int sum(int[] nums, int i, int j)
    {
       int sum = 0;
       while(i<=j){
           sum += nums[i];
           i++;
       }
        return sum;
    }

    private static int pivotIndex(int[] nums, int start, int end, int index)
    {
        if(index == nums.length-1){
            return -1;
        }
         int leftSum = sum(nums, start, index-1); 
         int rightSum = sum(nums, index+1, end);
         if(leftSum == rightSum){
             return index;
         }
         
        return pivotIndex(nums, start, end, index+1);
    }

    
}
