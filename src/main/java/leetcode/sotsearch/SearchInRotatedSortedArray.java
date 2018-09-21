package leetcode.sotsearch;

public class SearchInRotatedSortedArray
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] ia = {3, 1};
        int target = 1;
        System.out.println(search(ia, target, 0, ia.length - 1));
    }

    public static int search(int[] a, int x, int left, int right)
    {

        if(right < left)
        {
            return -1;
        }
        int mid = (left + right) / 2;
        if(a[mid] == x)
        {
            return mid;
        }

        if(a[left] < a[mid])
        {
            if(x >= a[left] && x < a[mid])
            {
                return search(a, x, left, mid - 1);
            }
            else
            {
                return search(a, x, mid + 1, right);
            }
        }
        else if(a[mid] < a[right])
        {
            if(x > a[mid] && x <= a[right])
            {
                return search(a, x, mid + 1, right);
            }
            else
            {
                return search(a, x, left, mid - 1);
            }
        }
        else if(a[left] == a[mid])
        {
            if(a[mid] != a[right])
            {
                return search(a, x, mid + 1, right);
            }
            else
            {
                int val = search(a, x, left, mid - 1);
                if(val == -1)
                {
                    return search(a, x, mid + 1, right);
                }
                else
                {
                    return val;

                }
            }

        }
        return -1;

    }
}
