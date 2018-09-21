package leetcode.array;

import java.util.Arrays;

public class NextPermutation
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] ia = {2, 3, 1};
        nextPermutation(ia);
    }

    public static void nextPermutation(int[] num) {
        if(num.length == 1){
            return;
        }
        boolean isDesc = true;
       
        int first = 0;
        for(int i=num.length-2;i>=0;i--){
            if(num[i] < num[i+1]){
                first = i;
                isDesc = false;
                break;
            }
        }
        
        if(isDesc){
            swap(num, 0, num.length-1);
            System.out.println(Arrays.toString(num));
            return;
        }
        
        int second = 0;
        for(int i=num.length-1;i>=0;i--){
            if(num[i] > num[first]){
                second = i;
                break;
            }
        }
        int temp = num[first];
        num[first] = num[second];
        num[second] = temp;
        
        swap(num, first+1, num.length-1);
        System.out.println(Arrays.toString(num));
    }

    private static void swap(int[] num, int i, int j)
    {
        while(i< j){
          
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }
        
    }
    
 
}
