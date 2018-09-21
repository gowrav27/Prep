package leetcode.sotsearch;

public class FindPeakElement
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] ia = {1, 2, 4, 3, 5, 6, 7, 8, 9};
        System.out.println("findPeakElement : " + findPeakElement(ia));
        System.out.println(2 << 1);
    }

    public static int findPeakElement(int[] num)
    {
        int low = 0;
        int high = num.length - 1;

        while(low < high)
        {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;
            if(num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
}
