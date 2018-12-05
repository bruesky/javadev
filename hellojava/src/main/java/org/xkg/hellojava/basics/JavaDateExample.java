package org.xkg.hellojava.basics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaDateExample {
    public static void main(String[] args) throws ParseException {
        java.util.Date date=new java.util.Date();
        System.out.println(date);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = format.parse("22/01/1988");
        System.out.println(date1);
    }
}
