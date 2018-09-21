package com.blogspot.aknowakowski.jodaTime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.chrono.ISOChronology;

public class JodaTimeTester
{
    private static final DateTimeZone MOSCOW = DateTimeZone.forID("Europe/Moscow");
    
    public static void main(String[] args)
    {
        System.out.println(new LocalDateTime(292278992, 6, 30, 0, 0).toString());
        DateTimeZone.setDefault(MOSCOW);
        DateTime maxDT = new DateTime(Long.MAX_VALUE);
        System.out.println(maxDT);

        DateTime maxDTt = new DateTime(System.currentTimeMillis());
        System.out.println(maxDTt);

        LocalDateTime localDateTime2 = new LocalDateTime(System.currentTimeMillis());
        System.out.println(localDateTime2);
        
        LocalDateTime localDateTime22 = new LocalDateTime(Long.MAX_VALUE, DateTimeZone.UTC);
//        System.out.println(localDateTime22);

        if(localDateTime22.toDateTime(DateTimeZone.UTC).getMillis() == Long.MAX_VALUE){
            System.out.println(true);
        }
        LocalDateTime localDateTime = new LocalDateTime(Long.MAX_VALUE, DateTimeZone.forID("Europe/Moscow"));
        System.out.println(localDateTime);


    }

}
