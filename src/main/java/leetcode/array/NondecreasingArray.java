package leetcode.array;

public class NondecreasingArray
{

    public static void main(String[] args)
    {
        int arr[] = {4,2,1};
        checkPossibility(arr);
        System.out.println(checkPossibility(arr));

    }
    
public boolean isToeplitzMatrix(int[][] matrix) {
        return true;
    }

    public static boolean checkPossibility(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int valid = 1;
        for(int i=1;i<nums.length;i++){
         
            if(nums[i-1] > nums[i]){
                valid--;
            }
            
        }
        if(valid < 0){
            return false;
        }
        return true;
    }
}
