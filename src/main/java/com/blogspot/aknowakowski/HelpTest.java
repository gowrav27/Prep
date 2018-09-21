package com.blogspot.aknowakowski;

import java.sql.Date;
import java.sql.Timestamp;

public class HelpTest
{

    public static void main(String[] args)
    {
        Date date = new java.sql.Date(System.currentTimeMillis() - 86400000);
        Timestamp t = new Timestamp(System.currentTimeMillis());
        System.out.println(t);
        System.out.println(date);

    }

}
