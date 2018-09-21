package com.blogspot.aknowakowski.jodaTime.divideConqueror;

import java.util.ArrayList;
import java.util.List;

// http://www.shiftedup.com/2015/05/07/five-programming-problems-every-software-engineer-should-be-able-to-solve-in-less-than-1-hour
public class DifferentWaysTo100
{

    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static List<String> allPossibilities(int[] numbers)
    {
        List<String> result = new ArrayList<String>();
        allPossibilities(numbers, result, 1, 1, "1");
        return result;
    }

    private static void allPossibilities(int[] numbers, List<String> result, int index, int sum, String expr)
    {
        if(sum == 100)
        {
            result.add(expr);
        }

        if(index == numbers.length)
            return;

        allPossibilities(numbers, result, index + 1, sum + numbers[index], expr + "+" + numbers[index]);

        allPossibilities(numbers, result, index + 1, sum - numbers[index], expr + "-" + numbers[index]);

        int plusPos = expr.lastIndexOf('+');
        int minusPos = expr.lastIndexOf('-');
        int pos;
        boolean positive;
        if(plusPos > minusPos)
        {
            pos = plusPos;
            positive = true;
        }
        else
        {
            pos = minusPos;
            positive = false;
        }
        int number = Integer.parseInt(expr.substring(pos + 1));

        allPossibilities(numbers, result, index + 1,
                positive ? (sum - number + (number * 10) + numbers[index]) : (sum + number - (number * 10 + numbers[index])),
                expr + numbers[index]);
    }

    public static void main(String[] args)
    {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(allPossibilities(numbers));
    }

}
