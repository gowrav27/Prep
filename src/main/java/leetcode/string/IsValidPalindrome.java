package leetcode.string;

public class IsValidPalindrome
{

    public static void main(String[] args)
    {
        int i = Integer.MAX_VALUE+1;
        System.out.println(i);
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

    }

    public static boolean isPalindrome(String s)
    {
        char[] list = s.toCharArray();
        int len = s.length() - 1;
        int start = 0;
        int end = s.length() - 1;
        while(start < end)
        {
            while(start < len && !isLetterOrDigit(list[start]))
            {
                start++;
            }
            while(end >= 0 && !isLetterOrDigit(list[end]))
            {
                end--;
            }
            if(start > end)
            {
                return false;
            }
            if(Character.toLowerCase(list[start]) != Character.toLowerCase(list[end]))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isLetterOrDigit(char c)
    {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

}
