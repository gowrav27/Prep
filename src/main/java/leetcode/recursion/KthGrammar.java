package leetcode.recursion;

public class KthGrammar
{
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(kthGrammar(1, 1));
    }
    
    public static int  kthGrammar(int N, int K)
    {
        String v = kthGrammar( N,   "0");
        return Integer.valueOf(v.charAt(K-1)-'0');
    }

    private static String  kthGrammar(int n, String string)
    {
        if(n==1){
            return string;
        }
        
        String temp = "";
        for(int i=0;i<string.length();i++){
            if(string.charAt(i) == '0'){
                temp += "01";
            }else{
                temp += "10";
            }
        }
        return kthGrammar(n-1, temp);
        
    }
}
