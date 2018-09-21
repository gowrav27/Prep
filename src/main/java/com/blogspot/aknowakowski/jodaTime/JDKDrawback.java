package com.blogspot.aknowakowski.jodaTime;

import java.util.*;
public class JDKDrawback 
{ 
    public static void main(String[] args) 
    { 
        int sourceSize = 300000 ; 
        int removalsSize = 300000 ;
         
        Set<Integer> source = new HashSet<Integer>(); 
        Collection<Integer> removals = new ArrayList<Integer>(); 
         
        for (int i = 0; i < sourceSize; i++) 
        { 
            source.add(i); 
        } 
        for (int i = 1; i <= removalsSize; i++) 
        { 
            removals.add(-i); 
        } 
         
        long start = System.currentTimeMillis(); 
        source.removeAll(removals); 
        long end = System.currentTimeMillis(); 
        long r = end - start;
        System.out.println("Time taken: " + (r) + "ms"); 
    } 
}