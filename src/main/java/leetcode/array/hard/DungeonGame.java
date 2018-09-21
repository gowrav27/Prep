package leetcode.array.hard;

public class DungeonGame
{
    static int[][] mem;

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP2(dungeon));
    }

    private static int helper(int[][] dungeon, int i, int j)
    {
        if(i >= dungeon.length || j >= dungeon[0].length)
            return Integer.MAX_VALUE;
        if(mem[i][j] > 0)
            return mem[i][j];
        int health = Integer.MAX_VALUE;
        health = Math.min(health, helper(dungeon, i + 1, j));
        health = Math.min(health, helper(dungeon, i, j + 1));
        health = health == Integer.MAX_VALUE ? 1 : health; // this only happens with i, j is P
                                                           // already
        int ret = health > dungeon[i][j] ? (health - dungeon[i][j]) : 1;
        mem[i][j] = ret;
        return ret;
    }

    public static int calculateMinimumHP2(int[][] dungeon)
    {
        if(dungeon.length == 0)
            return 0;
        mem = new int[dungeon.length][dungeon[0].length];
        return helper(dungeon, 0, 0);
    }

    public static int calculateMinimumHP(int[][] dungeon)
    {
        int[][] result = new int[dungeon.length][dungeon[0].length];
        result[dungeon.length - 1][dungeon[0].length - 1] = Integer.MAX_VALUE;
        helper(dungeon, result, 0, 0, 0);
        if(result[dungeon.length - 1][dungeon[0].length - 1] < 0)
        {
            return Math.abs(result[dungeon.length - 1][dungeon[0].length - 1]) + 1;
        }
        return result[dungeon.length - 1][dungeon[0].length - 1];
    }

    private static void helper(int[][] dungeon, int[][] result, int x, int y, int life)
    {
        if(x == dungeon.length || y == dungeon[0].length)
        {
            return;
        }
        if(x < dungeon.length && y < dungeon[0].length)
        {
            life = life + dungeon[x][y];
        }

        if(x == dungeon.length - 1 && y == dungeon[0].length - 1)
        {
            if(Math.abs(life) < Math.abs(result[dungeon.length - 1][dungeon[0].length - 1]))
            {
                result[dungeon.length - 1][dungeon[0].length - 1] = life;
            }
            return;
            // return life;
        }

        helper(dungeon, result, x + 1, y, life);
        helper(dungeon, result, x, y + 1, life);
    }
}
