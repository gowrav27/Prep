package com.blogspot.aknowakowski.jodaTime;

import java.util.ArrayList;

public class DivideConqueror
{
    private static int TARGET_SUM = 100;
    private static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    static ArrayList add(int digit, String sign, ArrayList branches) {
        for (int i = 0; i < branches.size(); i++) {
            branches.set(i, digit + sign + branches.get(i));
        }

        return branches;
    }

    static ArrayList<String> f(int sum, int number, int index) {
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

        ArrayList branch1 = f(sum - number, VALUES[index], index + 1);
        ArrayList branch2 = f(sum - number, -VALUES[index], index + 1);

        int concatenatedNumber = number >= 0
            ? 10 * number + VALUES[index]
            : 10 * number - VALUES[index];
        ArrayList branch3 = f(sum, concatenatedNumber, index + 1);

        ArrayList results = new ArrayList();

        results.addAll(add(digit, "+", branch1));
        results.addAll(add(digit, "-", branch2));
        results.addAll(add(digit, "", branch3));

        return results;
    }
    
    public static int total(int n, int[] v, int i) {
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if (i == v.length && n > 0) {
            return 0;
        }
        return total(n- v[i], v, i)+ total(n, v, i+1);
        
        
    }
    
    static int fib(int n)
    {
        if ( n <= 1 )
            return n;
        
        return fib(n -1) + fib (n-2);
    }

    public static void main(String[] args) {
        int[] v = {1,2,3};
        System.out.println(fib(9));
        System.out.println(total(5, v, 0));
//        for (String string : f(TARGET_SUM, VALUES[0], 1)) {
//            System.out.println(string);
//        }

    }
}
