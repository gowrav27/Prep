package com.blogspot.aknowakowski.jodaTime;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

public class TimeComparator
{

    public static final Date MAX_DATE = new Date(9223372036854775807L);
    public static final Timestamp MAX_TIMESTAMP = new Timestamp(MAX_DATE.getTime());
    static final TimeZone tz = TimeZone.getTimeZone("UTC");
    static final Calendar calendar = Calendar.getInstance(tz);
    static LocalDateTime localDateTime = new LocalDateTime(MAX_TIMESTAMP, DateTimeZone.forTimeZone(tz));

    public static void main(String[] args)
    {
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);

        System.out.println("SQL Date =" + MAX_DATE.getTime());
        System.out.println("Timestamp =" + MAX_TIMESTAMP.getTime());

        System.out.println("localDateTime with tz =" + localDateTime.toDateTime(DateTimeZone.forTimeZone(tz)).getMillis());
        System.out.println("localDateTime without tz =" + localDateTime.toDateTime().getMillis());

        System.out.println(new LocalDateTime(Long.MAX_VALUE).toDateTime(DateTimeZone.forTimeZone(tz)).getMillis());
        LocalDateTime localDateTime = new LocalDateTime(MAX_TIMESTAMP, DateTimeZone.forTimeZone(tz));
        System.out.println(
                localDateTime.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("America/Los_Angeles"))).getMillis());

        LocalDateTime localDateTime2 = new LocalDateTime(MAX_TIMESTAMP);
        System.out.println(localDateTime2.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("UTC"))).getMillis());
        System.out.println(localDateTime2.toDateTime().getMillis());

        System.out.println(localDateTime.toDateTime(DateTimeZone.UTC).getMillis());

    }

}
