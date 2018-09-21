package leetcode.array.hard;

public class IntegerToWords
{

    public static void main(String[] args)
    {
        new StringBuilder();
        // numberToWords(123456789);
        System.out.println(numberToWords(1000));
    }

    public static String numberToWords(int num)
    {
        if(num == 0)
            return "Zero";

        int i = 0;
        String words = "";

        while(num > 0)
        {
            if(num % 1000 != 0)
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private static String helper(int num)
    {
        if(num == 0)
            return "";
        else if(num < 20)
            return LESS_THAN_20[num] + " ";
        else if(num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }

    public static void numberToWords2(int num, StringBuilder sb)
    {
        if(num == 0)
            sb.append("Zero");

        int i = 0;

        while(num > 0)
        {
            if(num % 1000 != 0)
            {
                helper2(num % 1000, sb);
                sb.append(THOUSANDS[i]);
                sb.append(" ");
            }
            num /= 1000;
            i++;
        }
    }

    private static void helper2(int num, StringBuilder sb)
    {
        if(num == 0)
            sb.append("");
        else if(num < 20)
        {
            sb.append(LESS_THAN_20[num]);
            sb.append(" ");
        }
        else if(num < 100)
        {
            sb.append(TENS[num / 10]);
            sb.append(" ");
            helper2(num % 10, sb);
        }
        else
        {
            sb.append(LESS_THAN_20[num / 100]);
            sb.append(" Hundred");
            helper2(num % 100, sb);
        }
    }

    private final static String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final static String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety"};
    private final static String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
}
