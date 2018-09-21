package ctci.recursion;

import java.util.List;

public class NumberOfBraces
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    private static void braces(int n, int start, int end, String str, List<String> lists)
    {
        if(str.length() == 2 * n)
        {
            lists.add(str);
        }
        if(start < n)
        {
            braces(n, start + 1, end, str + "(", lists);
        }
        if(end < start)
        {
            braces(n, start, end + 1, str + ")", lists);
        }
    }
}
