package com.blogspot.aknowakowski.jodaTime;

import java.util.Date;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

public class Regex
{

    public static void main(String[] args)
    {

        Date DATE = new Date(25975807);
        System.out.println("DATE " + DATE);
        System.out.println("DATE " + new Date(0));
        System.out.println("DATE " + new Date(System.currentTimeMillis()));
        System.out.println("DATE " + new Date(System.currentTimeMillis() + 25975807));
        // System.out.println(Long.MAX_VALUE - 9223372036828800000L);

        Date ADJUSTED_MAX_DATE = new Date(9223372036828800000L);
        System.out.println("ADJUSTED_MAX_DATE " + ADJUSTED_MAX_DATE);

        Date MAX_DATE = new Date(Long.MAX_VALUE);
        System.out.println("MAX_DATE " + MAX_DATE);

        LocalDate firstDate = new LocalDate(9223372036828800000L);
        LocalDate secondDate = new LocalDate(9223372036828800000L);
        System.out.println("firstDate " + firstDate);
        System.out.println("secondDate " + secondDate);
        LocalDateTime firstDateTime = firstDate.toLocalDateTime(new LocalTime(0, 0));
        LocalDateTime secondDateTime = secondDate.toLocalDateTime(new LocalTime(0, 0));

        if(secondDateTime.isBefore(firstDateTime))
        {
            System.out.println("second date is before first Date");
        }
        else
        {
            System.out.println("first date is before second Date");
        }
        
    }

}
