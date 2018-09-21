package com.blogspot.aknowakowski.stackoverflow;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.Instant;

public class Test
{
    // private static final Pattern PATH_PATTERN = Pattern.compile("(/emails/\\d+)");
    private static final Pattern PATH_PATTERN = Pattern.compile("(/aliases/)(\\d+)(/\\w+)");
    private static final Pattern REMOVE_PATH_PATTERN = Pattern.compile("(/aliases/)(\\d+)");

    private static int trailingZeroes(int n)
    {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args)
    {
        // TimeZone.setDefault(TimeZone.);
        // System.setProperty("user.timezone", "EST");
        System.out.println(new Instant());
        System.out.println(trailingZeroes(5));
        System.out.println(3 << 0);
        String ss = "s";
        int nbn = ss.charAt(0);
        System.out.println(nbn);
        String s = "/person/deceasedCd";
        Matcher matcher = REMOVE_PATH_PATTERN.matcher(s);
        if(!matcher.matches())
        {
            System.out.println("Didnt match");
            // return null;
        }
        // System.out.println(matcher.group(2));
        String[] str = s.split("/");
        System.out.println(str);
         Set<String> patientFields = new HashSet<String>();
        patientFields.add("g");
        System.out.println(patientFields.contains("g"));
        // SecureRandom random = new SecureRandom();
        // byte bytes[] = new byte[20];
        // random.nextBytes(bytes);
        // System.out.println(random.nextDouble());
        // String string = "aemails0typePriority";
        // string.charAt(0);
        // char[] iji = string.toCharArray();
        // System.out.println("before");
        // System.out.println(iji);
        // Arrays.sort(iji);
        // System.out.println(iji);
        // System.out.println(string);
        // String[] str = string.split("/");
        // for(String s : str)
        // {
        // System.out.println(s);
        // }
        //
        //// EXAMPLE
        //// Input: Tact Coa
        //// Output: True (permutations:"taco cat'; "atco cta'; etc.)
        //
        // // System.out.println(string.substring(0, string.lastIndexOf('/')+1));
        // // System.out.println(isMatch(string));
        //
        // String test1 = "Hi Test2 Hi";
        // String test2 = "Test2";
        // System.out.println("hh - " + test1.indexOf(test2));
        //
        // String sg = "/emails/0/id";
        // int lastSlashIndex = sg.lastIndexOf("/");
        // System.out.println(sg.substring(0, lastSlashIndex));
        // System.out.println(TestEnum.SRV.toString());
        // String num = "123";
        // int hi = num.charAt(1) - '0';
        // System.out.println("advait" + hi);
        // // System.out.println("hh - " + test1.st);
        // //System.out.println(string.substring(0, string.lastIndexOf('/')+1));
        // //System.out.println(isMatch(string));
    }
    
    private static boolean isMatch(String string){
        Matcher matcher = PATH_PATTERN.matcher(string);
        if(!matcher.matches())
        {
            return false;
        }
        return true;
    }

}
