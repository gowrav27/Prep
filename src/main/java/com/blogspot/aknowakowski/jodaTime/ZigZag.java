package com.blogspot.aknowakowski.jodaTime;

public class ZigZag
{

    public static void main(String[] args)
    {
        String s = "PAYPALISHERE";
        int n =4;
//        zigZag(s.toCharArray(), n);
        System.out.println(convert(s, 1));
    }
    
    public static String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    private static String zigZag(char[] s, int n){
       char[][] a= new char[n][4];
       boolean down = true;
       int row = 0;
       int k = 0;
       int rowCurr = n-1;
       int len = s.length;
       for(int j =0 ;j<15; j++){
          for(int i=0;i<n;i++){
              if(down == false){
                  a[j][rowCurr] = s[k];
                  k++;
                  break;
              }
              a[j][i] = s[k];
              k++;
          }
          if(rowCurr == 0){
              down = true;
              rowCurr = n-1;
              j--;
              continue;
          }
          rowCurr = rowCurr -1;
          down = false;
       }
       return a.toString();
    }
}
