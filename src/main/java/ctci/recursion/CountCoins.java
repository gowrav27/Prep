package ctci.recursion;

import java.util.ArrayList;
import java.util.List;

public class CountCoins
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] coins = {25, 10, 5, 1};
        int n = 25;
        System.out.println(countCoins(coins, n, 0));
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        countCoins(coins, n, 0, new ArrayList<Integer>(), lists);
        System.out.println(lists);
        System.out.println(makeChange(n));
    }

    private static int countCoins(int[] coins, int n, int index)
    {
        if(index >= coins.length)
        {
            return 0;
        }
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        int count = 0;
        count += countCoins(coins, n - coins[index], index);
        count += countCoins(coins, n, index + 1);
        
        return count;
    }

    private static int countCoins(int[] coins, int n, int index, List<Integer> list, List<List<Integer>> lists)
    {
        if(index >= coins.length)
        {
            return 0;
        }
        if(n < 0)
        {
            return 0;
        }
        if(n == 0)
        {
            lists.add(new ArrayList<Integer>(list));

            return 1;
        }
        int count = 0;
        list.add(coins[index]);
        count += countCoins(coins, n - coins[index], index, list, lists);
        list.remove(list.size() - 1);
        count += countCoins(coins, n, index + 1, list, lists);

        return count;
    }

    static int makeChange(int amount, int[] denoms, int index)
    {
        if(index >= denoms.length - 1)
            return 1;
        int denomAmount = denoms[index];
        int ways = 0;
        for(int i = 0; i * denomAmount <= amount; i++)
        {
        int amountRemaining = amount - i * denomAmount;
        ways += makeChange(amountRemaining, denoms, index + 1);
        }
        return ways;
        }

    static int makeChange(int n)
    {
        int[] denoms = {25, 10, 5, 1};
        return makeChange(n, denoms, 0);
    }
}
