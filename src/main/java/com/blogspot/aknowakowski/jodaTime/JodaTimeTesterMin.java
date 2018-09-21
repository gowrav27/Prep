package com.blogspot.aknowakowski.jodaTime;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.TimeZone;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

public class JodaTimeTesterMin{


    public static void main(String[] args)
    {
        System.out.println(Long.MIN_VALUE);
        System.out.println(new Date(Long.MIN_VALUE));

        System.out.println(new java.sql.Timestamp(Long.MIN_VALUE));
        System.out.println(new Date(-644473600000L));
        System.out.println(new LocalDate(-11644473600000L));
    
    }

}
