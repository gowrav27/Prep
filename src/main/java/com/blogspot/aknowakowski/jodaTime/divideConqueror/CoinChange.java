package com.blogspot.aknowakowski.jodaTime.divideConqueror;

//http://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/
public class CoinChange
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    public static int total(int n, int[] v, int i) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        // means coins over and n>0 so no solution
        if (i == v.length && n > 0) {
            return 0;
        }
        return total(n - v[i], v, i) + total(n, v, i + 1);
    }
}
