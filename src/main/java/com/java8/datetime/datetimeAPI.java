package com.java8.datetime;

import org.w3c.dom.ls.LSOutput;

import java.time.*;

public class datetimeAPI {

    public static void main(String[] args) {
        System.out.println("joda time api.");
////////////////current system date and time /////////////////////////
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());

//////////////////////////////////////////////////////////////
        LocalDate ld = LocalDate.now();
        System.out.println("day of month >>"+ld.getDayOfMonth());
        System.out.println("month value  >>"+ld.getMonthValue());
        System.out.println("year         >>"+ld.getYear());
        System.out.println("day of year >>"+ld.getDayOfYear());
        System.out.println("day of week  >>"+ld.getDayOfWeek());
/////////////////////////////////////////////////////////////////

        System.out.println("custom day");
        LocalDate ldt = LocalDate.of(1987, 5,12);
        System.out.println("I was born on >>"+ldt.getDayOfWeek());

        LocalDate ldtNow= LocalDate.now();
        Period p = Period.between(ldt,ldtNow);
        System.out.println("my age is "+ p.getYears()+" years "+ p.getMonths()+ "  months " +p.getDays()+" days");








    }


}
