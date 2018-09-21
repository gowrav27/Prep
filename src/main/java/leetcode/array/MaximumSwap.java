package leetcode.array;

public class MaximumSwap
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int num = 1;
        System.out.println(maximumSwap3(num));
    }
    
    public static int maximumSwap3(int num) {
        
        int maxDigit = -1;
        int maxDigitIx = -1;
        int l  = -1;
        int r = -1;
        char[] digits = Integer.toString(num).toCharArray();
        for (int k = digits.length-1; k >= 0; k--) {
            if(digits[k] > maxDigit){
                maxDigit = digits[k];
                maxDigitIx = k;
                continue;
            }
            
            if(digits[k] < maxDigit){
                l = k;
                r = maxDigitIx;
            }
            
            
        }
        
        if(l==-1){
            return num;
        }
            char temp = digits[l];
            digits[l] = digits[r];
            digits[r] = temp;
            return Integer.valueOf(String.valueOf(digits));
    }

    public static int maximumSwap2(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        
        return num;
    }
    
    public static int maximumSwap(int num)
    {
        char[] nums = Integer.toString(num).toCharArray();

        int i = 0;
        while(i < nums.length)
        {
            int j = nums.length - 1;
            int max = nums.length - 1;
            while(j > i)
            {
                char back = nums[j];
                if(back > nums[max])
                {
                    max = j;
                }
                j--;
            }
            if(nums[i] < nums[max])
            {
                char temp = nums[max];
                nums[max] = nums[i];
                nums[i] = temp;
                break;
            }
            i++;
        }
        return Integer.valueOf(String.valueOf(nums));
    }
}
