package com.blogspot.aknowakowski;

/**
 *          1 2 3                        7 4 1
 *          4 5 6  --> 90 rotation       8 5 2
 *          7 8 9                        9 6 3
 */
public class Rotate90
{

    public static void main(String[] args)
    {
      int[][] mn = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {10,11, 12}};
      System.out.println(mn);
      int r = mn.length;
      int c = mn[0].length;
      int[][] mnn = new int[c][r];
//      for(int i=0;i<3;i++){
//          mnn[i] = new int[3];
//      }
      

      for(int row =0 ; row< mn.length ; row++){
          int end = mn[row].length;
          end--;
          for(int column=0; column < mn[row].length ; column++){
              mnn[row][column]  = mn[end][row];
              end--;
          }
      }
      System.out.println(mnn);

    }
}
