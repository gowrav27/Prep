package leetcode.string;

public class ImplementstrStr
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle)
    {
        if(haystack == null && needle == null)
        {
            return 0;
        }
        if(needle.isEmpty() && haystack.isEmpty())
        {
            return 0;
        }
        if(haystack == null || haystack.isEmpty())
        {
            return -1;
        }
        if(needle == null || needle.isEmpty())
        {
            return -1;
        }
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        for(int i = 0; i < s.length; i++)
        {
            if(s[i] == t[0])
            {
                int j = i;
                int k = 0;
                while(j < s.length && k < t.length)
                {
                    if(s[j] != t[k])
                    {
                        break;
                    }
                    j++;
                    k++;
                }
                if(k == t.length)
                {
                    return i;
                }
            }
        }
        return -1;
    }
}
