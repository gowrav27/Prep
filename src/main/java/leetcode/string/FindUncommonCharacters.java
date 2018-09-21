package leetcode.string;

public class FindUncommonCharacters
{
    public static void main(String[] args)
    {

        new FindUncommonCharacters();

        String s1 = "geeksforgeeks";
        String s2 = "geeksquiz";

        int[] a = findUncommonCharacters(s1, s2);

        for(int i = 0; i < 256; i++)
        {
            if(a[i] == 1 || a[i] == 2)
            {
                System.out.print(" " + (char) i);
            }
        }
    }

    /**
     * Approach : Build an array of 256 characters that serves as a hashmap arr[i] = -1 => char
     * occurs in both the strings arr[i] = 1 => char occurs in 1st string only arr[i] = 2 => char
     * occurs in 2nd string only
     * @param s1
     * @param s2
     * @return
     */
    public static int[] findUncommonCharacters(String s1, String s2)
    {

        int i = 0, j = 0, len1 = s1.length(), len2 = s2.length();
        int[] arr = new int[256];

        while(i < len1 && j < len2)
        {

            if(arr[s1.charAt(i)] == 2)
            {
                arr[s1.charAt(i)] = -1;
            }
            else if(arr[s1.charAt(i)] != -1)
            {
                arr[s1.charAt(i)] = 1;
            }

            if(arr[s2.charAt(j)] == 1)
            {
                arr[s2.charAt(j)] = -1;
            }
            else if(arr[s2.charAt(j)] != -1)
            {
                arr[s2.charAt(j)] = 2;
            }

            i++;
            j++;
        }

        while(i < len1)
        {

            if(arr[s1.charAt(i)] == 2)
            {
                arr[s1.charAt(i)] = -1;
            }
            else if(arr[s1.charAt(i)] != -1)
            {
                arr[s1.charAt(i)] = 1;
            }
            i++;
        }

        while(j < len2)
        {

            if(arr[s2.charAt(j)] == 1)
            {
                arr[s2.charAt(j)] = -1;
            }
            else if(arr[s2.charAt(j)] != -1)
            {
                arr[s2.charAt(j)] = 1;
            }
            j++;
        }

        return arr;
    }
}