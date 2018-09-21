package com.blogspot.aknowakowski.jodaTime;

import java.util.Arrays;
import java.util.Comparator;

public class MaxSomeProblem
{
    private static Integer[] VALUES = {52, 5, 3 };

    public static void main(String[] args) {
        Arrays.sort(VALUES, new Comparator() {




            public int compare(Object o1, Object o2)
            {
                String v1 = o1.toString();
                String v2 = o2.toString();

                return (v1 + v2).compareTo(v2 + v1) * -1;
            }
        });

        String result = "";
        for (Integer integer : VALUES) {
            result += integer.toString();
        }

        System.out.println(result);
    }   
}
