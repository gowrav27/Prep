package leetcode.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MyCalendarI
{



    
    static TreeMap<Integer, Integer> calendar = new TreeMap<Integer, Integer>();


    public static boolean book2(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        if (floorKey != null && calendar.get(floorKey) > start) return false;
        Integer ceilingKey = calendar.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false;

        calendar.put(start, end);
        return true;
    }
    
    public static void main(String[] args)
    {


        System.out.println();
        System.out.print(book2(47,50) +"--");
        System.out.print(book2(33, 41)+"--");
        System.out.print(book2(39, 45)+"--");
        System.out.print(book2(33, 42)+"--");
        System.out.print(book2(25, 32)+"--");
        
        System.out.print(book2(26, 35)+"--");
        System.out.print(book2(19, 25)+"--");
        System.out.print(book2(3, 8)+"--");
        System.out.print(book2(8, 13)+"--");
        System.out.print(book2(18, 27)+"--");
        System.out.println();
        System.out.print("true--true--false--false--true--false--true--true--true--false");
//        System.out.println(startToEnd);

    }

   
      
    

}

