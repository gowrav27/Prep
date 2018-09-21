package leetcode.recursion;

import java.util.Arrays;

public class WordSearch
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
//        char[][] c = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] c = {{'A'}, {'B'}};
        String word = "ABB";
        System.out.println(exist(c, word));
    }
    

    // works
    public static boolean exist(char[][] board, String word)
    {
        boolean[][] b = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(exist(board, b, word, 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, boolean[][] b, String word, int index, int i, int j)
    {
        if(index == word.length()){
            return true;
        }
        if(i< 0 || j<0){
            return false;
        }
        if(i>board.length-1 || j>board[0].length-1){
            return false;
        }
        
        if(board[i][j] == word.charAt(index) && !b[i][j]){
            b[i][j] = true;
           boolean v1 = exist(board, b, word, index+1, i-1, j);
           if(v1) return true;
           boolean v2 = exist(board, b, word, index+1, i+1, j);
           if(v2) return true;
           boolean v3 =  exist(board, b, word, index+1, i, j-1);
           if(v3) return true;
           boolean v4= exist(board, b, word, index+1, i, j+1);
           if(v4) return true;
           b[i][j] = false;           
        }
        
        return false;
    }
}
