package com.blogspot.aknowakowski.jodaTime.divideConqueror;

import java.util.ArrayList;

// http://www.shiftedup.com/2015/05/08/solution-to-problem-5-and-some-other-thoughts-about-this-type-of-questions
public class SIgnPossibilityNetSoln
{
    private static int TARGET_SUM = 6;
    private static int[] VALUES = {1, 2, 3};
    
    public static void main(String[] args)
    {
        for (String string : poss(TARGET_SUM, VALUES[0], 1)) {
            System.out.println(string);
        }

    }


    static ArrayList add(int digit, String sign, ArrayList branches) {
        for (int i = 0; i < branches.size(); i++) {
            branches.set(i, digit + sign + branches.get(i));
        }

        return branches;
    }

    static ArrayList<String> poss(int sum, int number, int index) {
        int digit = Math.abs(number % 10);
        if (index >= VALUES.length) {
            if (sum == number) {
                ArrayList result = new ArrayList();
                result.add(Integer.toString(digit));
                return result;
            }
            else {
                return new ArrayList();
            }
        }

        ArrayList branch1 = poss(sum - number, VALUES[index], index + 1);
        ArrayList branch2 = poss(sum - number, -VALUES[index], index + 1);

//        int concatenatedNumber = number >= 0
//            ? 10 * number + VALUES[index]
//            : 10 * number - VALUES[index];
//        ArrayList branch3 = poss(sum, concatenatedNumber, index + 1);

        ArrayList results = new ArrayList();

        results.addAll(add(digit, "+", branch1));
        results.addAll(add(digit, "-", branch2));
       // results.addAll(add(digit, "", branch3));

        return results;
    }
}
